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

	public SearchServerResponse findServerByParams(SearchServerRequest request, Pageable pageable) {

		SearchServerResponse response = new SearchServerResponse();
		
		pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());

		logger.info(" [Method]=findServerByParams pageable");
		Page<Server> servers = serverRepository.findByParams(request.getServerName(), request.getTeam(),
				request.getJbossVersion(), request.getManagerName(), request.getEnviornment(), request.getTier(),
				request.getType(), pageable);
		
		// Page<Server> servers_distinct = serverRepository.findDistincts(pageable);
		
        
		logger.info("find findServerByParams " + pageable);
		List<Server> serverslist = servers.getContent();
		logger.info("find findServerByParams Servers" + servers);
	//	List<Server> serversdistinct = servers_distinct.getContent();
	//	logger.info("find findServerByParams distincts" + servers_distinct);		
		SearchMetaData searchMetaData = new SearchMetaData();
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
	//	searchMetaData.setServerName(serversdistinct.iterator());
		response.setSearchMetaData(searchMetaData);
		logger.info("see the response " + response + searchMetaData);
		response.getAllServer().addAll(serverslist);
		return response;

	}

	public SearchServerResponse deleteServer(String serverName) {
		SearchServerResponse response = new SearchServerResponse();
		serverRepository.delete(serverName);
		response.getAllServer().remove(serverName);
		logger.info("delete server response " + response + serverName);
		return response;
	}

	public void addServer(final Server server) {
		logger.info(" [Method]= Adding started");
		SearchServerResponse response = new SearchServerResponse();
		serverRepository.save(server);
		response.getAllServer().add(server);
		logger.info("Server added" + response + server);
	}

	@Override
	public boolean isValid(Server server) {
		logger.info("Server add request validating" + server);
		return server != null && server.getServerName() != null && server.getManagerName() != null;

	}

}
