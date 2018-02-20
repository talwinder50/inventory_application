package services;

import java.util.List;

/**
 * This interface has operations to sync data between actual application instances and datasource
 * TODO: do we need callback?
 * @author Talwinder Kaur
 * @since 0.1
 *
 */
public interface DataSyncService {
	
	/**
	 * service which accepts list of application instance ids and then return the job id
	 * @param applicationInstanceIds
	 * @return job id
	 * Variation 1
	 */
	int syncApplicationInstances(List<Integer> applicationInstanceIds);
	
	
	/**
	 * @param applicationsIds
	 * @return
	 * Variation 2
	 * Create job, collect instances and re-use implementation of Variation 1
	 */
	int syncApplications(List<Integer> applicationsIds);
	
	/**
	 * @return
	 * Variation 3
	 * Create job, collect instances and re-use implementation of Variation 1
	 */
	int syncAll();
	
	/**
	 * Get detailed status of the job from database 
	 * 
	 * @param jobId
	 * @return detailed status of job
	 */
	DataSyncStatus checkStatus(int jobId);
	
	

}
