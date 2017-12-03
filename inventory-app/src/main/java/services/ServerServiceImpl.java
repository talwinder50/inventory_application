package services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Server;
import repository.ServerRepository;
import vo.SearchServerRequest;
import vo.SearchServerResponse;
@Service
@Transactional
public class ServerServiceImpl implements ServerService {

	private static final Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);
	@Autowired
	ServerRepository serverRepository;
	@Override
	public SearchServerResponse findServerBy(SearchServerRequest request) {
		SearchServerResponse response = new SearchServerResponse();
			
		if (request.getManagerName() != null ) {
				logger.info(" [Method]=findServerByManagerName");
				List<Server> servers= serverRepository.findByManagerNameContaining(request.getManagerName());
				response.getAllServer().addAll(servers);		
			}
		else if (request.getJboss_version() != 0 )   {
			logger.info(" [Method]=findServerByJbossVersion");
			List<Server> servers= serverRepository.findByServerJbossVersion(request.getJboss_version());
			response.getAllServer().addAll(servers);
		}
		else if (request.getTier() != null)   {
			logger.info(" [Method]=findServerByTier");
			List<Server> servers= serverRepository.findByTier(request.getTier());
			response.getAllServer().addAll(servers);
		}
		else if (request.getType() != null)   {
			logger.info(" [Method]=findServerByType");
			List<Server> servers= serverRepository.findByType(request.getType());
			response.getAllServer().addAll(servers);
		}
		else if (request.getEnviornment() != null)   {
			logger.info(" [Method]=findServerByEnviornment");
			List<Server> servers= serverRepository.findByEnviornment(request.getEnviornment());
			response.getAllServer().addAll(servers);
		}
		else if (request.getPatchingCycle() != null )   {
			logger.info(" [Method]=findServerByPatchingCycle");
			List<Server> servers= serverRepository.findByPatchingCycleContaining(request.getPatchingCycle());
			response.getAllServer().addAll(servers);
		}
		else if (request.getServerName() != null )   {
			logger.info(" [Method]=findServerByServerName");
		    List<Server> servers= serverRepository.findByServerNameLike(request.getServerName());
		    response.getAllServer().addAll(servers);
		}
		else {
			logger.info(" [Method]=findAll");
			List<Server> servers = serverRepository.findAll();
			response.getAllServer().addAll(servers);
			
		}
		return response;	
		
	}
    
    public SearchServerResponse updateServer(Server request){ 
        
    	SearchServerResponse response = new SearchServerResponse();
       serverRepository.save(request);
      
       List<Server> servers= serverRepository.findByServerNameLike(request.getServerName());
	   response.getAllServer().addAll(servers);
		logger.info(" [Method]=Updated Added");
       return response;
    }
    
    public SearchServerResponse deleteServer(Server request){ 

    	SearchServerResponse response = new SearchServerResponse(); 
    	    request.getServerName();
     	serverRepository.delete(request.getServerName());
     	
     	 List<Server> servers= serverRepository.findByServerNameLike(request.getServerName());
  	     response.getAllServer().remove(servers);
  	     logger.info(" [Method]=Server Deleted");
         return response;
     }

    
		
	}
	

