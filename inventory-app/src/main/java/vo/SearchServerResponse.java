package vo;
import java.util.LinkedList;
import java.util.List;

import model.Server;
public class SearchServerResponse {
	
	 protected List<Server> servers;

	 public List<Server> getAllServer() {
	        if (servers == null) {
	        	servers = new LinkedList<Server>();
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
