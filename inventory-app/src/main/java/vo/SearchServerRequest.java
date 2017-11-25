package vo;

public class SearchServerRequest {
	
	private String serverName;
	private String managerName;
	private double jboss_version;
	private String tier;
	private String type;
	private String enviornment;
	private String patchingCycle;

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

	public double getJboss_version() {
		return jboss_version;
	}

	public void setJboss_version(double jboss_version) {
		this.jboss_version = jboss_version;
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

	

}
