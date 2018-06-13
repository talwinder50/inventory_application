package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity
// @Table(name = "PatchingInfo")
public class PatchingInfo {
	@Id
	private String serverName;
	private String serverType;
	private Date patchingDate;
	private String Team;
	private String Manager;
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerType() {
		return serverType;
	}
	public void setServerType(String serverType) {
		this.serverType = serverType;
	}
	public Date getPatchingDate() {
		return patchingDate;
	}
	public void setPatchingDate(Date patchingDate) {
		this.patchingDate = patchingDate;
	}
	public String getTeam() {
		return Team;
	}
	public void setTeam(String team) {
		Team = team;
	}
	public String getManager() {
		return Manager;
	}
	public void setManager(String manager) {
		Manager = manager;
	}
	
	
}
