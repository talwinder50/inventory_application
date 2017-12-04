package services;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Application;
import repository.ApplicationRepository;
import vo.ApplicationRequest;
import vo.ApplicationResponse;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Override
	public ApplicationResponse findApplicationBy(ApplicationRequest request) {
		
		ApplicationResponse response = new ApplicationResponse();
		
		if (request.getApplicationName() != null ) {
			logger.info(" [Method]=findApplicationByName");
			List<Application> applications= applicationRepository.findByApplicationNameLike(request.getApplicationName());
			response.getAllApplication().addAll(applications);		
		}
	   else if (request.getServerName() !=null)   {
		logger.info(" [Method]=findApplicationByServerName");
		List<Application> applications= applicationRepository.findByServerNameLike(request.getServerName());
		response.getAllApplication().addAll(applications);
	   }
	   else if (request.getApplicationEnviornment() !=null)   {
			logger.info(" [Method]=findApplicationByEnviornment");
			List<Application> applications= applicationRepository.findByApplicationEnviornmentLike(request.getApplicationEnviornment());
			response.getAllApplication().addAll(applications);
		   }
	   else {
		   logger.info(" [Method]=findAllApplication");
		   List<Application> applications= applicationRepository.findAll();
			response.getAllApplication().addAll(applications);
	   }
		return response;			
		
	}

	public ApplicationResponse updateApplication(Application application) {
		 ApplicationResponse response = new ApplicationResponse();
		 applicationRepository.save(application);    
	     List<Application> applications= applicationRepository.findByApplicationNameLike(application.getApplicationName());
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
		
		
	}

	

	
}
