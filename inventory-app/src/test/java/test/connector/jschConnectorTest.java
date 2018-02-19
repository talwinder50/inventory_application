package test.connector;

import org.junit.Test;

import connectors.JschConnector;
import services.model.PrivateKey;
import services.model.RemoteFile;
import services.model.RemoteServer;

public class jschConnectorTest {
	
	@Test
	public void JschConnectorgetRemoteFileContent() throws Exception {

		RemoteFile remoteFile = new RemoteFile();
		remoteFile.setRemotefilepath("/home2/talwinde/sshtest/config.properties");
		PrivateKey privateKey = new PrivateKey("/Users/harwinderkaur/Desktop/id_rsa", "waheguru143");

		RemoteServer remoteServer = new RemoteServer("69.89.31.176", "talwinde", privateKey);
		new JschConnector(remoteServer).getRemoteFileContent(remoteFile);
	}
	
}
