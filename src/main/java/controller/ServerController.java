package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import model.Server;
import repository.ServerRepository;

@RestController
public class ServerController {

	@Autowired
	ServerRepository repo;
	@RequestMapping("/findallserver")
	public Iterable<Server> findAllServer() {

		Iterable<Server> servers = repo.findAll();
		return servers ;
	}
	/*@RequestMapping("/findallserver1")
	public Page<Server> findAllServer1() {

		Page<Server> servers = repo.findAll(10);
		return servers ;
	}
	*/
	@RequestMapping("/findByServerName")
	public Iterable<Server> findByServerName(@RequestParam("serverName") String server_name) {

		List<Server> servers = repo.findByServerName(server_name);

		return servers ;
	}
	
	@RequestMapping("/findByManagerName")
	public Iterable<Server> findByManagerName(@RequestParam("managerName") String manager_name) {

		List<Server> servers = repo.findByManagerNameContaining(manager_name);

		return servers ;
	}
	
	
}
