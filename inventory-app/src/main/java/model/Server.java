package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "server")
public class Server implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;

	@Id
  	@Column(name = "servername", unique = true, nullable = false, length = 180)
	private String servername;
	
	@Column(name = "manager_name")
	private String managerName;

	private String enviornment;

	@Column(name = "tier", nullable = false, length = 60)
	private String tier;

	@Column(name = "type", nullable = false, length = 60)
    private String type;

	@Column(name = "cpu", nullable = false, length = 60)
	private Integer cpuCount;

	@Column(name = "ssh_port", length = 60,nullable=false)
	private int sshPort;

	@Column(name = "memory", nullable = false, length = 60)
	private String ramAllocated;
 
	@Column(name = "container", nullable = false, length = 60)
	private String container;

	@Column(name = "patching_cycle", nullable = false, length = 60)
	private String patchingCycle;
	
	@Column(name = "team", nullable = true, length = 60)
	private String team;
	
	@OneToMany(mappedBy = "server")
    private List<ApplicationInstance> applicationInstances;


	public List<ApplicationInstance> getApplicationInstances() {
		return applicationInstances;
	}

	public void setApplicationInstances(List<ApplicationInstance> applicationInstances) {
		this.applicationInstances = applicationInstances;
	}

	public Server() {
	}
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public Integer getCpuCount() {
		return cpuCount;
	}

	public void setCpuCount(Integer cpuCount) {
		this.cpuCount = cpuCount;
	}

	public String getRamAllocated() {
		return ramAllocated;
	}

	public void setRamAllocated(String ramAllocated) {
		this.ramAllocated = ramAllocated;
	}

	public String getPatchingCycle() {
		return patchingCycle;
	}

	public void setPatchingCycle(String patchingCycle) {
		this.patchingCycle = patchingCycle;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getEnviornment() {
		return enviornment;
	}

	public void setEnviornment(String enviornment) {
		this.enviornment = enviornment;
	}

	public String getContainer() {
		return container;
	}

	public String getServerName() {
		return servername;
	}

	public void setServerName(String servername) {
		this.servername = servername;
	}

	public void setContainer(String container) {
		this.container = container;
	}
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}



	public int getSshPort() {
		return sshPort;
	}

	public void setSshPort(int sshPort) {
		this.sshPort = sshPort;
	}

	public Server(String serverName, String Responsible_manager, String type, String ram_allocated, int cpuCount,
			String container, String tier,String team) {

	//	getId().setServerName(serverName);
		this.managerName = Responsible_manager;
		this.type = type;
		this.tier = tier;
		this.container = container;
		this.cpuCount = cpuCount;
		this.team = team;

	}

}
