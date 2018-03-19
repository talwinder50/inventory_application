package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import model.Server;
import repository.ServerRepository;
import vo.SearchServerRequest;

/**
 * 
 * @author Talwinder Kaur
 *
 */
public class DataSyncServiceImpl implements DataSyncService {

	@Autowired
	ServerRepository serverRepository;
	/**
	 * TODO implementation
	 * This will submit the job and return response to caller synchronously
	 * Job will be executed Async
	 */
	@Override
	public int syncApplicationInstances(List<Integer> applicationInstanceIds) {
		// Add job id in database 
		// Call syncApplicationInstances in async way
		// return job id
		return 0;
		
	}

	/*
	 * TODO implementation
	 *  (non-Javadoc)
	 * @see services.DataSyncService#checkStatus(int)
	 */
	@Override
	public DataSyncStatus checkStatus(int jobId) {
		return null;
	}
	
	/** 
	 * TODO Implementation
	 * Take necessary steps to make it Async
	 * 
	 * Service call - is the call is relatime- boolean (TRUE/FALSE)
	 * Application - TSB/PIN/ETC
	 * Instances - UAT/PT/etc
	 * 
	 * 
	 * <ol>
	 * <li>Get all metadata for each id from database</li>
	 * <li>Call SSHService to retrieve config</li>
	 * <li>Update config in database using DAO</li>
	 * <li>Also update job status in DB using DAO</li>
	 * <li>Use Spring Async for concurrent executions wherever necessary</li>
	 * Call database to collect infor for SSHService list<Applicationinstances>
	 * For each application instances make a call to SSHService and get config 
	 * for each application instances persit the information in db 
	 * Return the response
	 * Call repository return response make sure the repo accepts filters . 
	 * More criteria in controller filtered results and vice - versa List<Applications>
	 * </ol>
	 * @param applicationInstanceIds
	 * @param jobId
	 */
	// @Async
	public void syncApplicationInstances(List<Integer> applicationInstanceIds, int jobId) {

	SearchServerRequest	request = new SearchServerRequest();
	// Page<Server> servers = serverRepository.findByParams(request.getServerName(), request.getUsername());
		
		
	}

	@Override
	public int syncApplications(List<Integer> applicationsIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int syncAll() {
		// TODO Auto-generated method stub
		return 0;
	}

}
