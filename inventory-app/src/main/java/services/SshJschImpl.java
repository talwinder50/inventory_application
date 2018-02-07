package services;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.JSchException;

import connectors.JschConnector;

/**
 * @author 
 * 
 * TODO: 
 * 1. This is SSHSerice Implementation
 * 2. It will call JschConnector for communication
 * 3. It will NOT have direct imports to Jsch library
 * 4. It is Spring Bean @Service
 *
 */
@Service
public class SshJschImpl implements SSHService {

	@Override
	public Map<String, String> parseFile(String hostname, String username, String filePath) throws JSchException {
		// TODO Auto-generated method stub
		
		try {
			JschConnector  jc = new JschConnector ();
			jc.open(hostname, username);
			jc.parse(filePath);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
