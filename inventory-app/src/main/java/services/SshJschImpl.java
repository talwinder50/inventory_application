package services;

import java.util.Map;

import org.springframework.stereotype.Service;

import connectors.JschConnector;
import services.model.RemoteFile;
import services.model.RemoteServer;

/**
 * 
 * TODO: write description
 * @author
 * 
 * @since 0.1
 *
 */
@Service
public class SshJschImpl implements SSHService {

	@Override
	public Map<String, String> parseFile(RemoteServer remoteServer, RemoteFile remoteFile) {
		JschConnector jschConnector = new JschConnector(remoteServer);
		return jschConnector.getRemoteFileContent(remoteFile);

	}
}
