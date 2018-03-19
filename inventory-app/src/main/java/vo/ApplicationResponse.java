package vo;

import java.util.LinkedList;
import java.util.List;

import model.ApplicationInstance;

public class ApplicationResponse {

	protected List<ApplicationInstance> applications;

	 public List<ApplicationInstance> getAllApplication() {
	        if (applications == null) {
	        	applications = new LinkedList<ApplicationInstance>();
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
