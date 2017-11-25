package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.ServerService;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

@RestController
public class ServerController {
    @Autowired
	ServerService service;
	@RequestMapping("/servers")
	public SearchServerResponse findBy(
			@RequestParam(value="managerName",required = false)String managerName,
			@RequestParam(value="jbossVersion",required = false ,defaultValue="0.0")Double jbossVersion,
			@RequestParam(value="tier",required = false)String tier,
			@RequestParam(value="type",required = false)String type,
			@RequestParam(value="enviornment",required = false)String enviornment,
			@RequestParam(value="patchingCycle",required = false)String patchingCycle,
			@RequestParam(value="serverName",required = false)String serverName)
	{
            
		SearchServerResponse response = new SearchServerResponse();
		SearchServerRequest request = new SearchServerRequest();
		request.setManagerName(managerName);
		request.setJboss_version(jbossVersion);
		request.setTier(tier);
		request.setType(type);
		request.setEnviornment(enviornment);
		request.setPatchingCycle(patchingCycle);
		request.setServerName(serverName);
		response = service.findServerBy(request);
		return response ;
	}
	
	
	
}
