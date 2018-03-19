package vo;

public class ApplicationRequest {
	private int applicationID;
	private String applicationName;
	private String serverName;
	private String username;
	private String password;
	private int port;
	private String maintenanceHours;
	private String applicationEnviornment;
	private int appLookupId;
	private boolean realtime;
	
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
	public int getAppLookupId() {
		return appLookupId;
	}
	public void setAppLookupId(int appLookupId) {
		this.appLookupId = appLookupId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRealtime() {
		return realtime;
	}
	public void setRealtime(boolean realtime) {
		this.realtime = realtime;
	}
}
