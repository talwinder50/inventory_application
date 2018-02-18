package services;



import java.util.Map;

import services.model.RemoteFile;
import services.model.RemoteServer;


/**
 * @author Talwinder Kaur
 *
 */
public interface SSHService {
	
	/**
	*/
	public Map<String, String> parseFile(RemoteServer remoteServer, RemoteFile remoteFile);
}
