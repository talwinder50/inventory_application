package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.ApplicationInstance;
import services.ApplicationInstanceService;
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
			response = service.findApplicationBy(request);
			return response ;
		}
	 @PostMapping("/applications")
		public ApplicationResponse addApplication(@RequestBody final ApplicationInstance application)
		{
		    ApplicationResponse response = new ApplicationResponse();
		    ApplicationRequest request = new ApplicationRequest();
			service.updateApplication(application);
			request.setApplicationName(application.getApplicationName());;
			response = service.findApplicationBy(request);
			return response; 
			
		}
		
	    @DeleteMapping("/applications")
	    public void deleteApplicationAll()
		{
			service.deleteApplicationAll();;
			
		}
		@DeleteMapping("/applications/{id}")
		public void deleteApplication(@PathVariable("id") int applicationId)
		{
		
			service.deleteApplication(applicationId);
	
			
		}
		
}
