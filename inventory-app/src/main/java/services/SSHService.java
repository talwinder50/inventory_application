package services;

import java.util.Map;

import com.jcraft.jsch.JSchException;

public interface SSHService {
	

	/**
	 * @param hostname 
	 * @param user for hostname
	 * @param filePath e.g. /apps/mindblowing/app.properties
	 * @return Key and Values of configuration file
	 * @throws JSchException 
	 */
	public Map<String, String> parseFile(String hostname, String user, String filePath) throws JSchException;

}
