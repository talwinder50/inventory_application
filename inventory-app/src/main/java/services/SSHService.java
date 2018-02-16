package services;



import java.util.Map;

import com.jcraft.jsch.JSchException;

import services.model.RemoteFile;
import services.model.RemoteServer;


/**
 * @author Talwinder Kaur
 *
 */
public interface SSHService {
	
	/**
	 * TODO: Add more details about interface
	 * @param filePath e.g. /apps/mindblowing/app.properties
	 * @return Key and Values of configuration file
	 * @throws 

 
  
	*/
	public Map<String, String> parseFile(RemoteServer remoteServer, RemoteFile remoteFile) throws JSchException;
    
}
