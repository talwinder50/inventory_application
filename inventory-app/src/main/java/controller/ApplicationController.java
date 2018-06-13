package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.ApplicationInstanceService;
import vo.ApplicationVO;
import vo.ApplicationDependenciesVO;
import vo.ApplicationInstancesVO;
import vo.ApplicationRequest;
import vo.ApplicationResponse;

@RestController
public class ApplicationController {

	 @Autowired
	 ApplicationInstanceService service;
	 
	 @CrossOrigin(origins = { "http://localhost:4200" })
	 @GetMapping("/applications")
	
	 public ApplicationResponse findBy(
				@RequestParam(value="appName",required = false)String applicationName,
				@RequestParam(value="enviornment",required = false)String applicationEnviornment,
				@RequestParam(value="serverName",required = false)String serverName)
		{
	            
		 ApplicationResponse response = new ApplicationResponse();
		 ApplicationRequest request = new ApplicationRequest();
			request.setApplicationName(applicationName);
			request.setApplicationEnviornment(applicationEnviornment);
		    request.setServerName(serverName);
			//response = service.
			return response ;
		}
	 
	 @GetMapping("/applicationsInstanceIds")
	 public ApplicationResponse findInstanceIds()
		{
	            
		 ApplicationResponse response = new ApplicationResponse();
			response = (ApplicationResponse) service.findApplications();
			return response ;
		}
	 
	 
	 /*@PostMapping("/applications")
		public ApplicationResponse addApplication(@RequestBody final ApplicationInstance application)
		{
		    ApplicationResponse response = new ApplicationResponse();
		    ApplicationRequest request = new ApplicationRequest();
		//	service.updateApplication(application);
			request.setApplicationName(application.getApplicationName());;
		//	response = service.findApplicationInstancesBy(request);
			return response; 
			
		}
		
	    @DeleteMapping("/applications")
	    public void deleteApplicationAll()
		{
		//	service.deleteApplicationAll();;
			
		}
		@DeleteMapping("/applications/{id}")
		public void deleteApplication(@PathVariable("id") int applicationId)
		{
		
		//	service.deleteApplication(applicationId);
	
			
		}
		*/
	 
	 @GetMapping("/applicationss")
	 public List<ApplicationVO> getApplications()
		{
		 /* Get all application from Application table
		  * Make call to the service ApplicationInstanceServiceImpl method findApplications();
		  * Return the list of Application Ids and name
		 */
		 List<ApplicationVO> applicationList = service.findApplications();

		 return applicationList;
		}
	 
	 @GetMapping("/applications/{applicationID}/dependencies")
	 public List<ApplicationDependenciesVO> getApplicationDependencies
	 (
				@RequestParam(value = "applicationID", required = false, defaultValue = "") int applicationID)
		{
		 /*  Lookup table Get all application from Application table join with dependency and dependency relation table
		     This will make the call to  ApplicationInstanceServiceImpl method findApplications(int applicationID);
		     Will return the list of dependecies for an application Id
		 */
		 return null;
		} 

	 @GetMapping("/applicationsInstances")
	 public List<ApplicationInstancesVO> getApplicationsInstances()
		{
		 /*
		  * This will make the call to  ApplicationInstanceServiceImpl method findApplicationInstances()
		  * Will return all the application instances we have 
		  */
		 return null;
		}
	 
	 @GetMapping("/applicationsInstances/{applicationID}")
	 public List<ApplicationInstancesVO> getAppInstancesbyApplicationID(
				@RequestParam(value = "applicationID", required = false, defaultValue = "") String applicationID
         )
		{
		 /*
		  * This will make the call to  ApplicationInstanceServiceImpl method findApplicationInstances(int applicationID);
		  * Will return all the application instances we have for a mentioned Application Id 
		  * For example all the instance of CSP application or CDS application
		  */
		 return null;
		}
	 
	 
}
