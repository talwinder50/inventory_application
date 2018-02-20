package services;

import java.util.Map;

import org.springframework.stereotype.Service;

import connectors.JschConnector;
import services.model.RemoteFile;
import services.model.RemoteServer;

/**
 * 
 * TODO: write description
 * @author Talwinder Kaur
 * 
 * @since 0.1
 *
 */
// TODO test with concurrent users and change bean scope to prototype
@Service
public class SshJschImpl implements SSHService {

	@Override
	public Map<String, String> parseFile(RemoteServer remoteServer, RemoteFile remoteFile) {
		JschConnector jschConnector = new JschConnector(remoteServer);
		return jschConnector.getRemoteFileContent(remoteFile);

	}

	/**
	 * Write new method in connector. No JSCh imports in this class
	 */
	@Override
	public RemoteCommandResponse executeRemoteCommand(RemoteCommandRequest remoteCommandRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see services.SSHService#executeRemote(services.RemoteCommandRequest)
	 */
	@Override
	public RemoteCommandChunkResponse executeRemote(RemoteCommandRequest remoteCommandRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
