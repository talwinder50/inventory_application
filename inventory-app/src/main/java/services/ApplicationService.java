package services;

import java.io.Serializable;

import model.Application;
import vo.ApplicationRequest;
import vo.ApplicationResponse;

public interface ApplicationService {
	 public ApplicationResponse findApplicationBy(ApplicationRequest request);
	 public ApplicationResponse updateApplication(Application request);
	 public void  deleteApplication(Serializable  applicationId) ;
	 public void  deleteApplicationAll() ;
}
