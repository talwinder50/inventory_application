package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Application")
public class Application {

	@Id
	@Column(name = "application_name", unique = true, nullable = false)
	private String applicationName;
	@Column(name = "server_name", unique = true, nullable = false)
	private String serverName;
	private int port;
	@Column(name = "maintenance_hours", unique = false, nullable = true)
	private String maintenanceHours;
	@Column(name = "application_enviornment", unique = false, nullable = true)
	private String applicationEnviornment;
	@ManyToOne
	@JoinColumn(name = "server_name", updatable = false, insertable = false, referencedColumnName = "server_name")
	protected Server server;

	@ManyToOne
	@JoinColumns(
			{
		@JoinColumn(name = "application_name", updatable = false, insertable = false, referencedColumnName = "dependant_name"),
		@JoinColumn(name = "application_name", updatable = false, insertable = false, referencedColumnName = "application_name")
			})
	protected DependantApplicationRelation dependant;
	
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

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

}
