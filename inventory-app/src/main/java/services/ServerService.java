package services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import model.Server;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

public interface ServerService {
	public SearchServerResponse findServerBy(SearchServerRequest request);
    public SearchServerResponse updateServer(Server request);
	public SearchServerResponse deleteServer(Server  request);
	//Page<Server> findPaginated(int page, int size);
	Page<Server> findPaginated(Pageable pageable);
	 
}
