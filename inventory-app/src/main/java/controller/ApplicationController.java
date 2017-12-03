package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Application;
import services.ApplicationService;
import vo.ApplicationRequest;
import vo.ApplicationResponse;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

	 @Autowired
	 ApplicationService service;
	 @GetMapping("/find")
	
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
	 @PostMapping("/add")
		public ApplicationResponse addApplication(@RequestBody final Application application)
		{
		    ApplicationResponse response = new ApplicationResponse();
		    ApplicationRequest request = new ApplicationRequest();
			service.updateApplication(application);
			request.setApplicationName(application.getApplicationName());;
			response = service.findApplicationBy(request);
			return response; 
			
		}
		
		@DeleteMapping("/delete")
		public ApplicationResponse deleteServer(@RequestBody final Application application)
		{
			ApplicationResponse response = new ApplicationResponse();
			ApplicationRequest request = new ApplicationRequest();
			service.deleteApplication(application);
			request.setApplicationName(application.getApplicationName());;
			response = service.findApplicationBy(request);
			return response; 
			
		}
		
}
