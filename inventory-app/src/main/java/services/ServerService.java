package services;

import org.springframework.data.domain.Pageable;

import model.Server;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

public interface ServerService {
	public SearchServerResponse findServerByParams(SearchServerRequest request, Pageable page);

	public SearchServerResponse deleteServer(String serverName);

	public void addServer(Server server);

	boolean isValid(Server server);
}
