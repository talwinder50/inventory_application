package services;

import java.io.Serializable;
import java.util.List;

import model.ApplicationInstance;
import vo.ApplicationRequest;
import vo.ApplicationResponse;

public interface ApplicationInstanceService {
	 public ApplicationResponse findApplicationInstancesBy(ApplicationRequest request);
	 public ApplicationResponse updateApplication(ApplicationInstance request);
	 public void  deleteApplication(Serializable  applicationId) ;
	 public void  deleteApplicationAll() ;
	 List<ApplicationInstance>  getAppIdRealtime(ApplicationRequest request);
	 List<ApplicationInstance>  getAppId(ApplicationRequest request);

}
