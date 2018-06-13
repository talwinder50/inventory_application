package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Application_Instance")
public class ApplicationInstance {
	/*
	 * This is application_instance detail table .
     Partial - realtime information is required specially status of application.
     Can be editable in admin page in future phase.  
     
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int applicationID;	
	@Column(name = "application_name", unique = false, nullable = false)
	private String applicationName;
	@Column(name = "servername", unique = false, nullable = false)
	private String serverName;
	@Column(name = "username", unique = false, nullable = false)
	private String username; 
	@Column(name = "port",unique = false, nullable = false)
	private int port;
	@Column(name = "maintenance_hours", unique = false, nullable = true)
	private String maintenanceHours;
	@Column(name = "application_enviornment", unique = false, nullable = true)
	private String applicationEnviornment;
	@Column(name = "status",unique = false, nullable = true)
	private Boolean status;
	@Column(name = "home_path",unique = false, nullable = true)
	private String homePath;   
	@Column(name = "password",unique = false, nullable = true)
	private String password;	
	@Column(name = "applookup_id",unique = false, nullable = true)
	private int appLookupId;
	//@Column(name = "app_property_key",unique = false, nullable = true)
	//private int applicationPropertyKey;
	
	@ManyToOne
	@JoinColumn(name = "servername",updatable = false, insertable = false, referencedColumnName = "servername")
	public Server server;
	
	@ManyToOne
	@JoinColumn(name = "applookup_id",updatable = false, insertable = false, referencedColumnName = "application_id")
	protected Application applicationLookup;
	
	@OneToMany(mappedBy = "applicationInstance")
    private List<InstanceConfigurationFile> instanceConfigurationFile;
	
	//@OneToMany(mappedBy = "propertyKey")
   // private List<InstanceConfigurationValues> propertyKey;
	
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

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getHomePath() {
		return homePath;
	}

	public void setHomePath(String homePath) {
		this.homePath = homePath;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAppLookupId() {
		return appLookupId;
	}

	public void setAppLookupId(int appLookupId) {
		this.appLookupId = appLookupId;
	}
	
	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public List<InstanceConfigurationFile> getInstanceConfigurationFile() {
		return instanceConfigurationFile;
	}

	public void setInstanceConfigurationFile(List<InstanceConfigurationFile> instanceConfigurationFile) {
		this.instanceConfigurationFile = instanceConfigurationFile;
	}
	/*public List<InstanceConfigurationValues> getPropertyKey() {
		return propertyKey;
	}

	public void setPropertyKey(List<InstanceConfigurationValues> propertyKey) {
		this.propertyKey = propertyKey;
	}
    */
}
