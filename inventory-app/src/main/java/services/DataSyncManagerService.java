package services;

import java.util.List;

import model.ApplicationInstance;
import model.Server;
import services.model.RemoteServer;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

public interface DataSyncManagerService {
	
	
	SearchServerResponse syncAll(SearchServerRequest request);
	List<ApplicationInstance> getDetails(SearchServerRequest request);
	

}
