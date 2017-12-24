package services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import model.Server;
import repository.ServerRepository;
import vo.SearchMetaData;
import vo.SearchServerRequest;
import vo.SearchServerResponse;
@Service
@Transactional
public class ServerServiceImpl implements ServerService {

	private static final Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);
	@Autowired
	ServerRepository serverRepository;

	public SearchServerResponse findServerBy(SearchServerRequest request,Pageable pageable) {
		SearchServerResponse response = new SearchServerResponse();
		
		pageable = new PageRequest(request.getPage(), request.getSize(),pageable.getSort());
		logger.info(" findServerBy "+pageable);
		if (request.getManagerName() != null ) {
				//logger.info(" [Method]=findServerByManagerName");
			Page<Server> servers= serverRepository.findByManagerNameContaining(request.getManagerName(),pageable);
				logger.info(" [Method]=findServerByManagerName"+ pageable);
				//response.getAllServer().addAll(servers);	
				List<Server> serverslist = servers.getContent();
				
				//Initialize metadata
			
				response.getAllServer().addAll(serverslist);
			}
		else if (request.getJbossVersion() != null )   {
			logger.info(" [Method]=findServerByJbossVersion");
			List<Server> servers= serverRepository.findByServerJbossVersion(request.getJbossVersion());
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
		else if (request.getTeam() != null )   {
			logger.info(" [Method]=findServerByTeam");
		    List<Server> servers= serverRepository.findByTeamLike(request.getTeam());
		    response.getAllServer().addAll(servers);
		}
		else if (request.getManagerName() != null && request.getJbossVersion() != null)   {
			
			Page<Server> servers= serverRepository.findByManagerNameContainingAndServerJbossVersion(request.getManagerName(), request.getJbossVersion(),pageable );
		    logger.info(" [Method]=findServerByJbossVersion&manager"+pageable);
		    List<Server> serverslist = servers.getContent();
			response.getAllServer().addAll(serverslist);
		}
		
		else {
			logger.info(" [Method]=findAll pageable");
			Page<Server> servers = serverRepository.findAll(pageable);
		   // List<Server> servers = serverRepository.findAll();
			//response.getAllServer().addAll(servers);
			logger.info("find sort " + pageable);
			List<Server> serverslist = servers.getContent();
			
			SearchMetaData searchMetaData =new SearchMetaData();
			searchMetaData.setTotalElements(servers.getTotalElements());
			searchMetaData.setSize(servers.getSize());
			searchMetaData.setFirst(servers.isFirst());
			searchMetaData.setLast(servers.isLast());
			searchMetaData.setTotalPages(servers.getTotalPages());
			searchMetaData.setNumber(servers.getNumber());
			searchMetaData.setNumberOfElements(servers.getNumberOfElements());
			searchMetaData.setHasNext(servers.hasNext());
			searchMetaData.setHasPrevious(servers.hasPrevious());
		    searchMetaData.setDirection(servers.getSort().toString());
			response.setSearchMetaData(searchMetaData);
			logger.info("see the response " + response + searchMetaData);
			response.getAllServer().addAll(serverslist);
		
		}
		
		return response;	
		
	}
	
	public SearchServerResponse findServerByParams(SearchServerRequest request,Pageable pageable) {
		
        SearchServerResponse response = new SearchServerResponse();
		
		pageable = new PageRequest(request.getPage(), request.getSize(),pageable.getSort());
		
		logger.info(" [Method]=findServerByParams pageable");
	Page<Server> servers = serverRepository.findByParams(request.getManagerName(),request.getTeam(), pageable);
	/*	Page<Server> servers = serverRepository.findByParams(request.getServerName(), request.getTeam(), request.getJbossVersion(),
				                                             request.getManagerName(), request.getEnviornment(),request.getTier(),
				                                             request.getType(),request.getRamAllocated(),request.getCpuCount(),
				                                             pageable); */
		logger.info("find findServerByParams " + pageable);
		List<Server> serverslist = servers.getContent();
		logger.info("find findServerByParams Servers" + servers);
		SearchMetaData searchMetaData =new SearchMetaData();
		searchMetaData.setTotalElements(servers.getTotalElements());
		searchMetaData.setSize(servers.getSize());
		searchMetaData.setFirst(servers.isFirst());
		searchMetaData.setLast(servers.isLast());
		searchMetaData.setTotalPages(servers.getTotalPages());
		searchMetaData.setNumber(servers.getNumber());
		searchMetaData.setNumberOfElements(servers.getNumberOfElements());
		searchMetaData.setHasNext(servers.hasNext());
		searchMetaData.setHasPrevious(servers.hasPrevious());
	    searchMetaData.setDirection(servers.getSort().toString());
		response.setSearchMetaData(searchMetaData);
		logger.info("see the response " + response + searchMetaData);
		response.getAllServer().addAll(serverslist);

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
    
   /* public Page<Server> findall(Server request,Pageable pageable){ 

    	 SearchServerResponse response = new SearchServerResponse(); 
     	
     	Page<Server> servers = (Page<Server>) serverRepository.findAll();
  	       response.getAllServer().remove(servers);
  	       logger.info(" [Method]=Server Deleted");
         return servers;
     }*/
    
    
	}
	

