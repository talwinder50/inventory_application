package services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ApplicationInstance;
import model.Server;
import repository.ServerRepository;
import services.model.PrivateKey;
import services.model.RemoteFile;
import services.model.RemoteServer;
import vo.SearchServerRequest;
import vo.SearchServerResponse;

@Service
public class DataSyncManagerServiceImpl implements DataSyncManagerService {
	private static final Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);
	@Autowired
	ServerRepository serverRepository;

	@Autowired
	SSHService sshservice;

	@Override
	public SearchServerResponse syncAll(SearchServerRequest request) {

		int i = 0;
		SearchServerResponse response = new SearchServerResponse();
		List<ApplicationInstance> resultlist = getDetails(request);
	  //  List<InstanceConfigurationFile> resultlist2 = getDetailsFile(request);
		response.getAllServerObject().addAll(resultlist);
		String path = "/home2/talwinde/sshtest/config.properties";
		PrivateKey privateKey = new PrivateKey("/Users/harwinderkaur/Desktop/id_rsa", "waheguru143");
		Iterator iterate = resultlist.iterator();
		while (i < response.getAllServerObject().size()) {
			String host = String.valueOf(resultlist.get(i).getServerName());
			String user = String.valueOf(resultlist.get(i).getUsername());
			String password = String.valueOf(resultlist.get(i).getPassword());
			String remoteFile ="/home2/talwinde/sshtest/config.properties";// String.valueOf(resultlist2.get(i).getConfigFilePath());
			System.out.println(
					"ssh connection details " + "  " + host + "  " + user + "  " + password + "  " + remoteFile);
			System.out.println("Start time " + System.currentTimeMillis());
			Map<String, String> map = sshservice.parseFile(new RemoteServer(host, user, privateKey),new RemoteFile(remoteFile));
			System.out.println("map sshservice " + "  " + map);
			System.out.println("End time " + System.currentTimeMillis());
			i++;
		}
		return response;
	}

	public List<ApplicationInstance> getDetails(SearchServerRequest request) {

		Server server = serverRepository.findServerUserPass(request.getServerName());
		return server.getApplicationInstances();
		
//		List<ApplicationInstance> resultlist = new ArrayList<ApplicationInstance>();
//		System.out.println("result of the servers" + "  " + servers);
//		
//		for(Server server: servers) {
//			ApplicationInstance app = new ApplicationInstance();
//			app.setServerName(server.getServerName());
//			app.setInstanceConfigurationFile(server.getIn);
//			
//		}
//		Iterator iterate = connectionDetails.iterator();
//		while (iterate.hasNext()) {
//			logger.debug("getting list of hostname");
//			Object[] line = (Object[]) iterate.next();
//			ApplicationInstance app = new ApplicationInstance();
//			app.setServerName((String) line[0]);
//			app.setUsername((String) line[1]);
//			app.setPassword((String) line[2]);
//			app.setInstanceConfigurationFile(connectionDetails.get(0).get);
//			for (InstanceConfigurationFile instanceConfigurationFile : connectionDetails) {
//				app.setInstanceConfigurationFile(instanceConfigurationFile.setConfigFilePath((String) line[3]));
//			}
//			resultlist.add(app);
//		}
//
//		System.out.println("Result List ..." + "  " + resultlist);
//
//		return resultlist;
	}

	/*
	 * for (ApplicationInstance application : connectionDetails) { Server server =
	 * new Server();
	 * historicalBookTypeList.add(responseTypeMappingHelper(connectionDetails,server
	 * )); } return connectionDetails; }
	 */
	/*
	 * private ApplicationInstance
	 * responseTypeMappingHelper(List<ApplicationInstance> connectionDetails,Server
	 * server ) {
	 * 
	 * ApplicationInstance application = new ApplicationInstance(); // Server server
	 * = new Server();
	 * 
	 * application.getServername().setServerName(server.getServerName());
	 * application.setUsername(((ApplicationInstance)
	 * connectionDetails).getUsername());
	 * application.setPassword(((ApplicationInstance)
	 * connectionDetails).getPassword());
	 * application.setHomePath(((ApplicationInstance)
	 * connectionDetails).getHomePath());
	 * 
	 * return application; }
	 */
}
