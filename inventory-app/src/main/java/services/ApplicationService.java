package services;

import model.Application;
import vo.ApplicationRequest;
import vo.ApplicationResponse;

public interface ApplicationService {
	 public ApplicationResponse findApplicationBy(ApplicationRequest request);
	 public ApplicationResponse updateApplication(Application request);
	 public ApplicationResponse deleteApplication(Application request);
}
