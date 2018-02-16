package connectors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * @author
 * 
 * 		TODO 1. This is wrapper for JSCH library 2. Create methods to
 *         communicate to library 3. It will have jsch imports
 *
 */

public class JschConnector {
	private static final Logger LOG = Logger.getLogger(JschConnector.class);

	// Constants
	private static final String STRICT_HOSTKEY_CHECKIN_KEY = "StrictHostKeyChecking";
	private static final String STRICT_HOSTKEY_CHECKIN_VALUE = "no";
	private static final String CHANNEL_TYPE = "shell";

	private String username;
	private String hostname;
	private int port;
	private Session session;
	private PrintStream ps;
	private InputStream input;
	private OutputStream ops;
	private Channel channel;

	public JschConnector(String hostname, String username, int port) {
		this.hostname = hostname;
		this.username = username;
		this.port = port;
	}

	public void open() throws JSchException, IOException {

		String privateKey = "/Users/harwinderkaur/Desktop/id_rsa";

		final JSch jsch = new JSch();

		jsch.addIdentity(privateKey, "waheguru143");
		LOG.info("Indentity Added");
		session = jsch.getSession(username, hostname, port);
		session.setConfig(STRICT_HOSTKEY_CHECKIN_KEY,
				STRICT_HOSTKEY_CHECKIN_VALUE);
		
		LOG.debug("-- Try to connect to the server " + hostname + ":" + port + " with user " + hostname);
		session.connect();
		LOG.debug("-- Connection OK");
		
		LOG.debug("-- Open SSH channel");
		channel = session.openChannel(CHANNEL_TYPE);
		input = channel.getInputStream();
        
		//ops = channel.getOutputStream();
		//ps = new PrintStream(ops, true);
		
		channel.connect();
		LOG.debug("-- Open SSH channel OK");

	}
	public String executeCommand(String command) throws IOException {
		ps.println(command);

		int size = 1024;
		final byte[] tmp = new byte[size];
		final StringBuilder sb = new StringBuilder();

		while (true) {
			while (input.available() > 0) {
				int i = input.read(tmp, 0, 1024);
				if (i < 0) {
					break;
				}
				sb.append(new String(tmp, 0, i));
			}

			final String output = sb.toString();
			if (output.contains("object")) {
				break;
			}

			if (channel.isClosed()) {
				if (input.available() > 0) {
					int i = input.read(tmp, 0, 1024);
					sb.append(new String(tmp, 0, i));
				}
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				LOG.error(e);
			}
		}

		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.AutoCloseable#close()
	 */
	public void close() throws Exception {
		// Close channel
		channel.disconnect();
		// Close session
		session.disconnect();
	}
	
}

