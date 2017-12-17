package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Exceptions.MyResourceNotFoundException;
import model.Server;
import services.ServerService;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

@RestController
public class ServerController {
    @Autowired
	ServerService service;
    @CrossOrigin(origins = {"http://localhost:4200"})
	@GetMapping("/servers")
	public SearchServerResponse findBy(
			@RequestParam(value="managerName",required = false)String managerName,
			@RequestParam(value="jbossVersion",required = false )String jbossVersion,
			@RequestParam(value="tier",required = false)String tier,
			@RequestParam(value="type",required = false)String type,
			@RequestParam(value="enviornment",required = false)String enviornment,
			@RequestParam(value="patchingCycle",required = false)String patchingCycle,
			@RequestParam(value="serverName",required = false)String serverName,
			@RequestParam(value="team",required = false)String team)
	{            
		SearchServerResponse response = new SearchServerResponse();
		SearchServerRequest request = new SearchServerRequest();
		request.setManagerName(managerName);
		request.setJbossVersion(jbossVersion);
		request.setTier(tier);
		request.setType(type);
		request.setEnviornment(enviornment);
		request.setPatchingCycle(patchingCycle);
		request.setServerName(serverName);
		request.setTeam(team);
		response = service.findServerBy(request);
		return response ;
	}
	
     
	/*@GetMapping(value = "/servers", params = { "page", "size" })
	public Page<Server> findPaginated(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {

		Page<Server> resultPage = service.findPaginated(page, size);
		if (page > resultPage.getTotalPages()) {
			throw new MyResourceNotFoundException("code : 2002 invalid page number");
		}

		return resultPage;
	}*/
    
    @GetMapping(value="/servers",params = { "page", "size" })
	Page<Server> list( Pageable pageable){
		Page<Server> servers = service.findPaginated(pageable);
		return servers;
	} 

    
	@PostMapping("/servers")
	public SearchServerResponse addServer(@RequestBody final Server server)
	{
		SearchServerResponse response = new SearchServerResponse();
		SearchServerRequest request = new SearchServerRequest();
		service. updateServer(server);
		request.setServerName(server.getServerName());;
		response = service.findServerBy(request);
		return response; 
		
	}
	
	@DeleteMapping("/servers")
	public SearchServerResponse deleteServer(@RequestBody final Server server)
	{
		SearchServerResponse response = new SearchServerResponse();
		SearchServerRequest request = new SearchServerRequest();
		service.deleteServer(server);
		request.setServerName(server.getServerName());;
		response = service.findServerBy(request);
		return response; 
		
	}
	
}
