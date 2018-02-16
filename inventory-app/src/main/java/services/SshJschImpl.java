package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

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
	public Map<String, String> parseFile(RemoteServer remoteServer, RemoteFile remoteFile) throws JSchException {
		// TODO Auto-generated method stub
		
		JschConnector jsch = new JschConnector(remoteServer.getHost(),
				                              remoteServer.getUser(),
				                              remoteServer.getPort());
		try {
			jsch.open();
			jsch.executeCommand("scp -f "+remoteFile.getRemotefilepath());
			Properties MyPropertyFile= new Properties();
			FileInputStream ip = new FileInputStream(".properties file path");
			MyPropertyFile.load(ip);
			
			Map<String, String> map=new Map<String, String>();
			Set keys = (Set) MyPropertyFile.keySet();
			
			for(Object k:keys){
			    String key=(String) k;
			    String value=MyPropertyFile.getProperty(key);

			//    if(row.charAt(0)==value.charAt(0))// check row's first character and values first character are same.
			        map.put(key, value);
			  //  }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	 
	

}
