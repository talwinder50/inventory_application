package services;

import java.io.Serializable;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ApplicationInstance;
import repository.ApplicationRepository;
import vo.ApplicationRequest;
import vo.ApplicationResponse;

@Service
public class ApplicationInstanceServiceImpl implements ApplicationInstanceService {
   /*
    * If the realtime = true this service will call DataSyncManager method syncall 
    * - DataSyncManager syncall method will call sshparsefile method of Jschconnector
    * - Will open the connection stream and parse the files 
    * - But how to do this efficiently in terms of 100 applications ? Shall we control refresh button on the UI- Refresh option on per instances 
    * - only or Refresh button on all instances. 
    * - After parsing this will call the repository again to insert the properties values in the database : Which properties to populate ?? 
    * - May be it will read the properties of that specific instance from the database and then update the values ...? 
    * 
    * If the realtime = false 
    */
	private static final Logger logger = LoggerFactory.getLogger(ApplicationInstanceServiceImpl.class);
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Override
	public ApplicationResponse findApplicationInstancesBy(ApplicationRequest request) {
		return null ; 
	
		
	/*	ApplicationResponse response = new ApplicationResponse();
		
		if (request.getApplicationName() != null ) {
			logger.info(" [Method]=findApplicationByName");
			List<ApplicationInstance> applications= applicationRepository.findByApplicationNameLike(request.getApplicationName());
			response.getAllApplication().addAll(applications);		
		}
	   else if (request.getServerName() !=null)   {
		logger.info(" [Method]=findApplicationByServerName");
		List<ApplicationInstance> applications= applicationRepository.findByServerLike(request.getServerName());
		response.getAllApplication().addAll(applications);
	   }
	   else if (request.getApplicationEnviornment() !=null)   {
			logger.info(" [Method]=findApplicationByEnviornment");
			List<ApplicationInstance> applications= applicationRepository.findByApplicationEnviornmentLike(request.getApplicationEnviornment());
			response.getAllApplication().addAll(applications);
		   }
	   else {
		   logger.info(" [Method]=findAllApplication");
		   List<ApplicationInstance> applications= applicationRepository.findAll();
			response.getAllApplication().addAll(applications);
	   }
		return response;			
		
	}*/
	}

	/*public ApplicationResponse updateApplication(ApplicationInstance application) {
		 ApplicationResponse response = new ApplicationResponse();
		 applicationRepository.save(application);    
	     List<ApplicationInstance> applications= applicationRepository.findByApplicationNameLike(application.getApplicationName());
		 response.getAllApplication().addAll(applications);
		logger.info(" [Method]=Applications Updated Added");
	     return response;
	}


	public void deleteApplicationAll() {
		logger.info(" [Method]=Application going to Delete");
		applicationRepository.deleteAll();
		logger.info(" [Method]=Application Deleted");
	
	}

	public void  deleteApplication(Serializable  applicationId) {
		// TODO Auto-generated method stub
		logger.info(" [Method]=Application going to Delete");
		applicationRepository.delete((int) applicationId);;
		logger.info(" [Method]=Application Deleted");
		
		
	}*/

	@Override
	public List<ApplicationInstance> getAppIdRealtime(ApplicationRequest request) {
		/*
		 * It will take the application id as parameter and  List of ApplicationInstances as response. 
		 * Inside it will make the call to DataSync manager method to fetch the
		 *  MAP<String, string> and update the configuration keys with updated values and then send the response to the database. 
		 */
		return null;
	}

	@Override
	public List<ApplicationInstance> getAppId(ApplicationRequest request) {
		/*
		 * It Will take application id as parameter and List of Applicationinstances as response . 
		 * Inside it will make the repository and fetch all the instances and Configuration File values and 
		 * send the bulk response to the front end. 
		 */
		return null;
	}

	@Override
	public ApplicationResponse updateApplication(ApplicationInstance request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteApplication(Serializable applicationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteApplicationAll() {
		// TODO Auto-generated method stub
		
	}

	

	
}
