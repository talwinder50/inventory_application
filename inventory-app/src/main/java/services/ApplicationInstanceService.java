package services;

import java.util.List;

import model.ApplicationInstance;
import vo.ApplicationDependenciesVO;
import vo.ApplicationInstancesVO;
import vo.ApplicationResponse;
import vo.ApplicationVO;
//Rename application service class
public interface ApplicationInstanceService {
	 // Not in use 
	 /*public ApplicationResponse findApplicationInstancesBy(ApplicationRequest request);
	 public ApplicationResponse updateApplication(ApplicationInstance request);
	 public void  deleteApplication(Serializable  applicationId) ;
	 public void  deleteApplicationAll() ; */
	
	 // Application request has to light weight, create a seaparte POJO or super and child POJO 
	// If its just an id then create a int o ID
	// List of id can come in future .. will be different interface
	 ApplicationResponse  getAppInstancesRealtime(List<Integer> applicationId);
	 ApplicationResponse  getAppInstances(List<Integer> applicationId);
	 
	 /*
	  * This will make call to Application Repository and fetch the application ids and name
	  */
	 List<ApplicationVO>  findApplications(); 
	 List<ApplicationDependenciesVO> findApplications(int applicationID);
	 List<ApplicationInstancesVO> findApplicationInstances();
	 List<ApplicationInstancesVO> findApplicationInstances(int applicationID);
  
}
