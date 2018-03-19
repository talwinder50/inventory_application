package vo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import model.Server;

public class SearchServerResponse {


	protected List<Server> servers;
	protected List<Object> object;
	// protected Page<Server> server;

	private SearchMetaData searchMetaData;

	public SearchMetaData getSearchMetaData() {
		return searchMetaData;
	}

	public void setSearchMetaData(SearchMetaData searchMetaData) {
		this.searchMetaData = searchMetaData;
	}

	public List<Server> getAllServer() {
		if (servers == null) {
			servers = new LinkedList<Server>();
		}
		return this.servers;
	}
	
	public List<Object> getAllServerObject() {
		if (object == null) {
			object = new LinkedList<Object>();
			
		
		}
		return this.object;
		
	}

	@Override
	public String toString() {
		return "ServerResponse [Servers=" + servers + ", toString()=" + super.toString() + "]";
	}
	

}
