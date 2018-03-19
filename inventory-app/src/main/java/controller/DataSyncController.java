package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.DataSyncManagerService;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

@RestController
public class DataSyncController {
	@Autowired
	DataSyncManagerService dataSyncManagerService;

	@GetMapping("/sync/all")
	public SearchServerResponse syncAll(@RequestParam(value = "servername", required = false, defaultValue = "") String serverName) {
		SearchServerResponse response = new SearchServerResponse();
		SearchServerRequest request = new SearchServerRequest();
		request.setServerName(serverName);
		response = dataSyncManagerService.syncAll(request);
		return response;
	}

}
