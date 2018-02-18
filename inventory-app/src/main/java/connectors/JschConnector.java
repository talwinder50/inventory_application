package connectors;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import services.model.RemoteFile;
import services.model.RemoteServer;

/**
 * TODO: write description
 * @author 
 * @since 0.1
 */

public class JschConnector {
	private static final Logger logger = Logger.getLogger(JschConnector.class);

	// Constants
	private static final String STRICT_HOSTKEY_CHECKIN_KEY = "StrictHostKeyChecking";

	// Channel Types
	private static final String CHANNEL_TYPE_SFTP = "sftp";

	private RemoteServer remoteServer;

	static {
		Properties config = new Properties();
		config.put(STRICT_HOSTKEY_CHECKIN_KEY, "no");
		JSch.setConfig(config);
	}

	public JschConnector(RemoteServer remoteServer) {
		this.remoteServer = remoteServer;
	}

	public Map<String, String> getRemoteFileContent(RemoteFile remoteFile) {
		Map<String, String> map = new HashMap<>();
		Session session = null;
		ChannelSftp sftp = null;
		try {
			JSch jsch = new JSch();
			if (remoteServer.isPasswordAuth()) {
			} else {
				jsch.addIdentity(remoteServer.getPrivateKey().getKey(), remoteServer.getPrivateKey().getPassword());
			}
			session = jsch.getSession(remoteServer.getUser(), remoteServer.getHost(), remoteServer.getPort());

			session.connect();
			sftp = (ChannelSftp) session.openChannel(CHANNEL_TYPE_SFTP);
			sftp.connect();
			InputStream inputStream = sftp.get(remoteFile.getRemotefilepath().toString());
			BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
			Properties props = new Properties();
			props.load(bufferedStream);
			for (final Entry<Object, Object> entry : props.entrySet()) {
				map.put((String) entry.getKey(), (String) entry.getValue());
			}
		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException("Exception ocuured");
		} finally {
			sftp.disconnect();
			session.disconnect();
		}
		return map;
	}
}
