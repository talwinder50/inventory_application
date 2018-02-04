package services;

import java.util.Map;

public interface SSHService {
	

	/**
	 * @param hostname 
	 * @param user for hostname
	 * @param filePath e.g. /apps/mindblowing/app.properties
	 * @return Key and Values of configuration file
	 */
	public Map<String, String> parseFile(String hostname, String user, String filePath);

}
