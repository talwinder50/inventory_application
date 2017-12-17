package vo;

public class SearchServerRequest {
	
	private String serverName;
	private String managerName;
	private String jbossVersion;
	private String tier;
	private String type;
	private String enviornment;
	private String patchingCycle;
	private String team;

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

	

}
