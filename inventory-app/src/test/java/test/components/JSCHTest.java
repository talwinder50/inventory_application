package test.components;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class JSCHTest {
	public static void main(String[] args) {
		try {
			String command = "tail -f /var/log/server.log";
			// String command = "ls";
			String host = "host";
			String user = "user";
			String password = "password";

			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);

			session.setPassword(password);
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream input = channel.getInputStream();
			channel.connect();

			System.out.println("Channel Connected to machine " + host + " server with command: " + command);

			try {
				InputStreamReader inputReader = new InputStreamReader(input);
				BufferedReader bufferedReader = new BufferedReader(inputReader);
				String line = null;

				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
				System.out.println("Closing ");
				bufferedReader.close();
				inputReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			channel.disconnect();
			session.disconnect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}