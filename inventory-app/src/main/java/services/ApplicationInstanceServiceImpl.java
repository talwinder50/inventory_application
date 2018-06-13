package services;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Application;
import model.ApplicationInstance;
import repository.ApplicationInstanceRepository;
import repository.ApplicationRepository;
import repository.InstanceConfigurationFileRepository;
import vo.ApplicationDependenciesVO;
import vo.ApplicationInstancesVO;
import vo.ApplicationResponse;
import vo.ApplicationVO;
import vo.SearchServerRequest;

@Service
public class ApplicationInstanceServiceImpl implements ApplicationInstanceService {
	/*
	 * If the realtime = true this service will call DataSyncManager method syncall
	 * - DataSyncManager syncall method will call sshparsefile method of
	 * Jschconnector - Will open the connection stream and parse the files - But how
	 * to do this efficiently in terms of 100 applications ? Shall we control
	 * refresh button on the UI- Refresh option on per instances - only or Refresh
	 * button on all instances. - After parsing this will call the repository again
	 * to insert the properties values in the database : Which properties to
	 * populate ?? - May be it will read the properties of that specific instance
	 * from the database and then update the values ...?
	 * 
	 * If the realtime = false
	 */
	private static final Logger logger = LoggerFactory.getLogger(ApplicationInstanceServiceImpl.class);
	 @Autowired
	 ApplicationRepository applicationRepository;
	@Autowired
	ApplicationInstanceRepository applicationInstanceRepository;

	@Autowired
	InstanceConfigurationFileRepository instanceConfigurationFileRepository;

	@Autowired
	RealTimeValueService realTimeValueService;

	/*
	 * ApplicationResponse response = new ApplicationResponse();
	 * 
	 * if (request.getApplicationName() != null ) {
	 * logger.info(" [Method]=findApplicationByName"); List<ApplicationInstance>
	 * applications=
	 * applicationRepository.findByApplicationNameLike(request.getApplicationName())
	 * ; response.getAllApplication().addAll(applications); } else if
	 * (request.getServerName() !=null) {
	 * logger.info(" [Method]=findApplicationByServerName");
	 * List<ApplicationInstance> applications=
	 * applicationRepository.findByServerLike(request.getServerName());
	 * response.getAllApplication().addAll(applications); } else if
	 * (request.getApplicationEnviornment() !=null) {
	 * logger.info(" [Method]=findApplicationByEnviornment");
	 * List<ApplicationInstance> applications=
	 * applicationRepository.findByApplicationEnviornmentLike(request.
	 * getApplicationEnviornment());
	 * response.getAllApplication().addAll(applications); } else {
	 * logger.info(" [Method]=findAllApplication"); List<ApplicationInstance>
	 * applications= applicationRepository.findAll();
	 * response.getAllApplication().addAll(applications); } return response;
	 * 
	 * }
	 */

	/*
	 * public ApplicationResponse updateApplication(ApplicationInstance application)
	 * { ApplicationResponse response = new ApplicationResponse();
	 * applicationRepository.save(application); List<ApplicationInstance>
	 * applications= applicationRepository.findByApplicationNameLike(application.
	 * getApplicationName()); response.getAllApplication().addAll(applications);
	 * logger.info(" [Method]=Applications Updated Added"); return response; }
	 * 
	 * 
	 * public void deleteApplicationAll() {
	 * logger.info(" [Method]=Application going to Delete");
	 * applicationRepository.deleteAll();
	 * logger.info(" [Method]=Application Deleted");
	 * 
	 * }
	 * 
	 * public void deleteApplication(Serializable applicationId) { // TODO
	 * Auto-generated method stub
	 * logger.info(" [Method]=Application going to Delete");
	 * applicationRepository.delete((int) applicationId);;
	 * logger.info(" [Method]=Application Deleted");
	 * 
	 * 
	 * }
	 */

	@Override
	public ApplicationResponse getAppInstancesRealtime(List<Integer> applicationId) {
		/*
		 * name - Request Response Steps : 
		 * Call rest endpoint get
		 * /applicationInstancesIds - List of ids. 
		 * Call another rest end point /applicationInstanceInfo 
		 * Based on the application id fetch the server name of that application id 
		 * Then call the RealtimeValueService method to fetchRealtime and pass the server request(Which will have the server name)
		 * fetchRealtime method will return the map<Keys, values) ;
		 * ApplicationResponse class will wrap the map and getAppInstancesRealtime returns  ApplicationResponse to controller

		 * In addition, There will be separate standalone time based scheduler which
		 * will make the call to the server and update the database after certain time.
		 * Trigger will the specific time , scheduler will have have the trigger .
		 */

		SearchServerRequest request = new SearchServerRequest();

		realTimeValueService.fetchRealtime(request);

		return null;
	}

	@Override
	public ApplicationResponse getAppInstances(List<Integer> applicationId) {
		/*
		 * Steps : Call rest endpoint get /applicationInstancesIds - List of ids. 
		 * Call another restendpoint /applicationInstanceInfo.
		 * In the service this method will loop through the list of the ids.
		 * In the loop will pass the application id to fetch the configuration file of the instance
		 * Fetch the values and properties and store it in Map<string, string> 
		 * Response will have a property and value of each instance wrapped in \
		 */
		ApplicationResponse response = new ApplicationResponse();
		for (int id : applicationId) {
			HashMap<String, String> instanceConfigurationValues = instanceConfigurationFileRepository
					.findByInstanceConfigurationFile(id);
		}
		return response;

	}

	@Override
	public List<ApplicationVO> findApplications() {
		/*
		 * (non-Javadoc)
		 * 
		 * @see services.ApplicationInstance#findApplication() This will make the call
		 * to repository fetch the applications and find dependent application.
		 *
		 */
		List<Application> applications = applicationRepository.findAll();
		List<ApplicationVO> applicationslist = (List<ApplicationVO>) applications.listIterator();

		return applicationslist;
	}

	@Override
	public List<ApplicationDependenciesVO> findApplications(int applicationId) 
	{
		/*
		 * This will make the call to applicationRepository to fetch all the dependecies of given application ID
		 */
		return null;
	}

	@Override
	public List<ApplicationInstancesVO> findApplicationInstances() {
		/*
		 * This will make the call to applicationInstanceRepository to fetch all applicationInstances
		 */
		List<ApplicationInstance> applicationsInstances = applicationInstanceRepository.findAll();
		List<ApplicationInstancesVO> applicationsInstancesList = (List<ApplicationInstancesVO>) applicationsInstances.listIterator();
		return applicationsInstancesList;
	}

	@Override
	public List<ApplicationInstancesVO> findApplicationInstances(int applicationID) {
		/*
		 * This will make the call to applicationInstanceRepository to fetch all applicationInstances by application ID
		 */
		List<ApplicationInstance> applicationsInstancesbyAppID = applicationInstanceRepository.findByAppLookupId(applicationID);
		List<ApplicationInstancesVO> applicationsInstancesList = (List<ApplicationInstancesVO>) applicationsInstancesbyAppID.listIterator();

		return applicationsInstancesList;

		
	}

}
