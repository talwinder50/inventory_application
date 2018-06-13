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
public class RealTimeValueImpl implements RealTimeValueService {
	private static final Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);
	@Autowired
	ServerRepository serverRepository;

	@Autowired
	SSHService sshservice;

	@Override
	public SearchServerResponse fetchRealtime(SearchServerRequest request) {

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
	}
}
