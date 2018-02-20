package services;

import java.util.List;

/**
 * 
 * @author Talwinder Kaur
 *
 */
public class DataSyncServiceImpl implements DataSyncService {

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
	 * <ol>
	 * <li>Get all metadata for each id from database</li>
	 * <li>Call SSHService to retrieve config</li>
	 * <li>Update config in database using DAO</li>
	 * <li>Also update job status in DB using DAO</li>
	 * <li>Use Spring Async for concurrent executions wherever necessary</li>
	 * </ol>
	 * @param applicationInstanceIds
	 * @param jobId
	 */
	// @Async
	public void syncApplicationInstances(List<Integer> applicationInstanceIds, int jobId) {
		
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
