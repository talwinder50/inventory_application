package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import model.Server;
import repository.ServerRepository;
@Service
public class ServerInfoImpl implements ServerInfo {

	
	@Autowired
	ServerRepository repo;
	
	@Override
	public Iterable<Server> findAll() {
		Iterable<Server> search = (Iterable<Server>) repo.findAll();
		return search;
	}
	
	public Iterable<Server> findByServerName(String ServerName) {
		
		Iterable<Server> search = (Iterable<Server>) repo.findByServerName(ServerName);
		return search;
	}

	@Override
	public Iterable<Server> findByManagerName(String ManagerName) {
		
		Iterable<Server> search = (Iterable<Server>) repo.findByManagerNameContaining(ManagerName);
		return search;
	}
	
}
