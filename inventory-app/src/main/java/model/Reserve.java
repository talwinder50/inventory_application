package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity
// @Table(name = "Reserve")
public class Reserve {
	@Id
	private String reserveID;
	
	private String projectCode;
	private String projectName;
	private String applicationName;
	private Date toDate;
	private Date fromDate;
	private String reserveBy;
	private boolean reserveState;
	private String DownStreamApplication;
	
	public String getReserveID() {
		return reserveID;
	}
	public void setReserveID(String reserveID) {
		this.reserveID = reserveID;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public String getReserveBy() {
		return reserveBy;
	}
	public void setReserveBy(String reserveBy) {
		this.reserveBy = reserveBy;
	}
	public boolean isReserveState() {
		return reserveState;
	}
	public void setReserveState(boolean reserveState) {
		this.reserveState = reserveState;
	}
	public String getDownStreamApplication() {
		return DownStreamApplication;
	}
	public void setDownStreamApplication(String downStreamApplication) {
		DownStreamApplication = downStreamApplication;
	}
}
