package vo;

public class ApplicationRequest {
	private int applicationID;
	private String applicationName;
	private String serverName;
	private int port;
	private String maintenanceHours;
	private String applicationEnviornment;
	
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getMaintenanceHours() {
		return maintenanceHours;
	}
	public void setMaintenanceHours(String maintenanceHours) {
		this.maintenanceHours = maintenanceHours;
	}
	public String getApplicationEnviornment() {
		return applicationEnviornment;
	}
	public void setApplicationEnviornment(String applicationEnviornment) {
		this.applicationEnviornment = applicationEnviornment;
	}
}
