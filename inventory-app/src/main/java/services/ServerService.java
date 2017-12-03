package services;


import model.Server;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

public interface ServerService {
	public SearchServerResponse findServerBy(SearchServerRequest request);
    public SearchServerResponse updateServer(Server request);
	public SearchServerResponse deleteServer(Server  request);
	 
}
