package vo;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;

import model.Server;
public class SearchServerResponse {
	
	 protected List<Server> servers;
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
	        	servers =  new LinkedList<Server>();
	        }
	        return this.servers;
	    }
	 @Override
		public String toString() {
			return "ServerResponse [Servers="
					+ servers + ", toString()=" + super.toString()
					+ "]";
		}
    
		
	
}
