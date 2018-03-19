package controller;

import java.net.URI;

import org.hibernate.mapping.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import model.Server;
import services.ServerService;
import services.ServerServiceImpl;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

@RestController
public class ServerController {
	@Autowired
	ServerService service;
	private static final Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);

	@CrossOrigin(origins = { "http://localhost:4200" })

	@GetMapping("/servers")
	public SearchServerResponse findBy(
			@RequestParam(value = "managerName", required = false, defaultValue = "") String managerName,
			@RequestParam(value = "jbossVersion", required = false, defaultValue = "") String jbossVersion,
			@RequestParam(value = "tier", required = false, defaultValue = "") String tier,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "enviornment", required = false, defaultValue = "") String enviornment,
			@RequestParam(value = "patchingCycle", required = false, defaultValue = "") String patchingCycle,
			@RequestParam(value = "servername", required = false, defaultValue = "") String serverName,
			@RequestParam(value = "team", required = false, defaultValue = "") String team,
			@SortDefault(sort = "servername", direction = Direction.ASC) @PageableDefault(page = 0, size = 10) Pageable pageable) {

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
		response = service.findServerByParams(request, pageable);
		return response;
	}

	@DeleteMapping("/servers/{serverName}")
	public SearchServerResponse deleteServer(@PathVariable(value = "servername") String serverName,
			@PageableDefault(page = 0, size = 10) @SortDefault(sort = "servername", direction = Direction.ASC) Pageable pageable) {
		logger.info(" Delete starting ");
		SearchServerResponse response = new SearchServerResponse();
		SearchServerRequest request = new SearchServerRequest();
		request.setServerName(serverName);
		response = service.findServerByParams(request, pageable);
		if (response.getAllServer() == null) {
			logger.info(" Server not found ");
		} else {
			service.deleteServer(serverName);
			logger.info(" Server deleted ");
		}

		return response;
	}

	@PostMapping("/servers")
	public @ResponseBody ResponseEntity<List> addServer(@RequestBody Server newserver) {

		if (service.isValid(newserver)) {
			service.addServer(newserver);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().query("serverName={serverName}")
					.buildAndExpand(newserver.getServerName()).toUri();
			logger.info("new record location " + location);
			return ResponseEntity.created(location).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

	}

	@PutMapping("/servers/{serverName}")
	public @ResponseBody ResponseEntity<List> updateServer(@PathVariable(value = "servername") String serverName,
			@RequestBody Server newserver) {
		if (service.isValid(newserver)) {
			service.addServer(newserver);
			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/servers").query("serverName={serverName}")
					.buildAndExpand(newserver.getServerName()).toUri();
			logger.info("updated record location " + location);
			return ResponseEntity.created(location).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

	}

}
