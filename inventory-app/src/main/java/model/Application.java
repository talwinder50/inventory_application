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
@Table(name = "Application")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int applicationID;
	@Column(name = "application_name", unique = false, nullable = false)
	private String applicationName;
	@Column(name = "server_name", unique = false, nullable = false)
	private String serverName;
	private int port;
	@Column(name = "maintenance_hours", unique = false, nullable = true)
	private String maintenanceHours;
	@Column(name = "application_enviornment", unique = false, nullable = true)
	private String applicationEnviornment;
	@Column(name = "Status",unique = false, nullable = true)
	private Boolean status;
	@Column(name = "home_path",unique = false, nullable = true)
	private Boolean homePath;
	

	@ManyToOne
	@JoinColumn(name = "server_name", updatable = false, insertable = false, referencedColumnName = "server_name")
	protected Server server;
	
	@OneToMany(mappedBy = "dependantId")
    private List<DependantApplicationRelation> dependant_applications;
	
	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
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

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/*public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}*/
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
