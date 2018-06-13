package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity
// @Table(name = "Manager")
public class Manager {
	
	//TODO: Rename the table to person or achive a generic functionality. No manager speicific

	@Id
	private String managerID;
	private String managerName;
	private String team;

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		team = team;
	}

}
