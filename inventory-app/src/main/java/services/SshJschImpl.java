package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.hibernate.mapping.Set;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import connectors.JschConnector;
import services.model.RemoteFile;
import services.model.RemoteServer;

/**
 * @author
 * 
 * 		TODO: 1. This is SSHSerice Implementation 2. It will call
 *         JschConnector for communication 3. It will NOT have direct imports to
 *         Jsch library 4. It is Spring Bean @Service
 *
 */
@Service
public class SshJschImpl implements SSHService {

	@Override
	public Map<String, String> parseFile(RemoteServer remoteServer, RemoteFile remoteFile) throws JSchException {
		// TODO Auto-generated method stub

		JschConnector jsch = new JschConnector(remoteServer.getHost(), remoteServer.getUser(), remoteServer.getPort());
		try {
			jsch.open();
			jsch.executeCommand("scp -f " + remoteFile.getRemotefilepath());
			Properties prop = new Properties();
			Map<String, String> map = new HashMap<String, String>();
			try {
			FileInputStream inputStream = new FileInputStream(remoteFile.getRemotefilepath());
				prop.load(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Some issue finding or loading file....!!! " + e.getMessage());

			}
			for (final Entry<Object, Object> entry : prop.entrySet()) {
				map.put((String) entry.getKey(), (String) entry.getValue());
			}
			return map;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return null;
	}
}
