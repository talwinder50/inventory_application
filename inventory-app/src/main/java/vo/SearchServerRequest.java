package vo;

import org.springframework.data.domain.Sort;


public class SearchServerRequest {
	
	private String serverName;
	private String managerName;
	private String jbossVersion;
	private String tier;
	private String type;
	private String enviornment;
	private String patchingCycle;
	private String team;
	private int page;
	private int size;
	private String fieldname;
	private String ramAllocated;
	private String cpuCount;
	private String username;

	public String getCpuCount() {
		return cpuCount;
	}

	public void setCpuCount(String cpuCount) {
		this.cpuCount = cpuCount;
	}

	public String getRamAllocated() {
		return ramAllocated;
	}

	public void setRamAllocated(String ramAllocated) {
		this.ramAllocated = ramAllocated;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	
	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEnviornment() {
		return enviornment;
	}

	public void setEnviornment(String enviornment) {
		this.enviornment = enviornment;
	}

	public String getPatchingCycle() {
		return patchingCycle;
	}

	public void setPatchingCycle(String patchingCycle) {
		this.patchingCycle = patchingCycle;
	}

	public String getJbossVersion() {
		return jbossVersion;
	}

	public void setJbossVersion(String jbossVersion) {
		this.jbossVersion = jbossVersion;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

}
