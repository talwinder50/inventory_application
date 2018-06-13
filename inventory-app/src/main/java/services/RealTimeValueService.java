package services;

import java.util.List;

import model.ApplicationInstance;
import model.Server;
import services.model.RemoteServer;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

public interface RealTimeValueService {
	
	
	SearchServerResponse fetchRealtime(SearchServerRequest request);
	List<ApplicationInstance> getDetails(SearchServerRequest request);
	

}
