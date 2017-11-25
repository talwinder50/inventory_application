package services;


import vo.SearchServerRequest;
import vo.SearchServerResponse;

public interface ServerService {
	public SearchServerResponse findServerBy(SearchServerRequest request);
	 
}
