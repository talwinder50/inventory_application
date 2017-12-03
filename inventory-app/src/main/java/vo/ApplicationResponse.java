package vo;

import java.util.LinkedList;
import java.util.List;

import model.Application;

public class ApplicationResponse {

	protected List<Application> applications;

	 public List<Application> getAllApplication() {
	        if (applications == null) {
	        	applications = new LinkedList<Application>();
	        }
	        return this.applications;
	    }
	 @Override
		public String toString() {
			return "ApplicationResponse [Application="
					+ applications + ", toString()=" + super.toString()
					+ "]";
		}

}
