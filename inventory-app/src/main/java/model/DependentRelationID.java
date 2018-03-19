package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class DependentRelationID implements Serializable {

	private static final long serialVersionUID = 1L;
	private int applicationId;
	private int dependancyId;

	public DependentRelationID() {
	}

	public DependentRelationID(int applicationId, int dependancyId) {
		this.applicationId = applicationId;
		this.dependancyId = dependancyId;
	}
	
	
	
	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getDependancyId() {
		return dependancyId;
	}

	public void setDependancyId(int dependancyId) {
		this.dependancyId = dependancyId;
	}

}