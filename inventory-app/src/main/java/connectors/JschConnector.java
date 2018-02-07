package connectors;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
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

	Session session = null;

	private String username = "talwinde";
	private String hostname = "69.89.31.176";

	public JschConnector() {
	}

	public JschConnector(String hostname, String username) {
		this.hostname = hostname;
		this.username = username;
	}

	public void open() throws JSchException {
		open(this.hostname, this.username);
	}

	public void open(String hostname, String username) throws JSchException {

		String privateKey = "/Users/harwinderkaur/Desktop/id_rsa";

		JSch jsch = new JSch();

		jsch.addIdentity(privateKey,"waheguru143");
		// jsch.setKnownHosts("/Users/harwinderkaur/.ssh");
		System.out.println("identity added ");
		session = jsch.getSession(username,hostname,22);		
		System.out.println("session created.");		
		System.out.println("session about connect.....");
		java.util.Properties config = new java.util.Properties(); 
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();
		System.out.println("session connected.....");
		// session.setServerAliveInterval(5000); // Check if server is alive every 5 seconds
		// session.setServerAliveCountMax(5); 
		System.out.println("Connecting SSH to " + hostname + " - Please wait for few seconds... ");
		session.connect();
		System.out.println("Connected!");
	}

	public String runCommand(String command) throws JSchException, IOException {

		String ret = "";

		if (!session.isConnected())
			throw new RuntimeException("Not connected to an open session.  Call open() first!");

		ChannelExec channel = null;
		channel = (ChannelExec) session.openChannel("exec");
		channel.setCommand(command);
		channel.setInputStream(null);

		new PrintStream(channel.getOutputStream());
		InputStream in = channel.getInputStream(); // channel.getInputStream();

		channel.connect();

		// you can also send input to your running process like so:
		// String someInputToProcess = "something";
		// out.println(someInputToProcess);
		// out.flush();

		ret = getChannelOutput(channel, in);

		channel.disconnect();

		System.out.println("Finished sending commands!");

		return ret;
	}

	private String getChannelOutput(Channel channel, InputStream in) throws IOException {

		byte[] buffer = new byte[1024];
		StringBuilder strBuilder = new StringBuilder();

		String line = "";
		while (true) {
			while (in.available() > 0) {
				int i = in.read(buffer, 0, 1024);
				if (i < 0) {
					break;
				}
				strBuilder.append(new String(buffer, 0, i));
				System.out.println(line);
			}

			if (line.contains("logout")) {
				break;
			}

			if (channel.isClosed()) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception ee) {
			}
		}

		return strBuilder.toString();
	}

	public void close() {
		session.disconnect();
		System.out.println("Disconnected channel and session");
	}

	public void parse(String filePath) throws IOException {

		try {
			open(username, hostname);
			String ret = runCommand("view" + filePath);
			System.out.println(ret);
			close();
		} catch (JSchException e) {
			Assert.fail(e.getMessage());
		}
	}

	public void StartStopServer( String filePath) throws IOException {

		try {
			open(username, hostname);
			String ret = runCommand("./" + filePath);
			System.out.println(ret);
			close();
		} catch (JSchException e) {
			Assert.fail(e.getMessage());
		}
	}

	public void cpucores(String username, String host) throws IOException {

		try {
			open(username, host);
			String ret = runCommand("nproc");
			System.out.println(ret);
			close();
		} catch (JSchException e) {
			Assert.fail(e.getMessage());
		}
	}

	public static void main(String[] args) {

		JschConnector ssh = new JschConnector();
		try {
			System.out.println("connection opening ...");
			ssh.open();
			System.out.println("connection opened");
			String ret = ssh.runCommand("ls -l");
			System.out.println(ret);
			ssh.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
