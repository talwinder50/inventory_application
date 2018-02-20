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
	// TODO rename method to readRemoteFile?
	public Map<String, String> parseFile(RemoteServer remoteServer, RemoteFile remoteFile);
	
	/**
	 * @param remoteCommandRequest
	 * @return
	 */
	public RemoteCommandResponse executeRemoteCommand(RemoteCommandRequest remoteCommandRequest);
	
	// TODO research how to send chnunk response - e.g. tail command - byte []?
	public RemoteCommandChunkResponse executeRemote(RemoteCommandRequest remoteCommandRequest);
}
