package services;



import java.util.Map;

import services.model.RemoteFile;
import services.model.RemoteServer;
import vo.RemoteCommandChunkResponse;
import vo.RemoteCommandRequest;
import vo.RemoteCommandResponse;


/**
 * @author Talwinder Kaur
 *
 */
public interface SSHService {
	
	/**
	 * e.g. app.properties
	 * it will parse defined keys from specific configuration remote file located on remote server
	 * 
	 *  TODO: add another parameter with List<String> keysToParse
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
