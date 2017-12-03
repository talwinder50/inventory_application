package model;

import java.io.Serializable;

public class DependentRelationID implements Serializable{
	
	private int applicationId;
	private int dependantId;
 
	public DependentRelationID() {
 
	}
 
	public DependentRelationID(int applicationId, int dependantId) {
		this.applicationId = applicationId;
		this.dependantId = dependantId;
	}
 
	public int getApplicationId() {
		return applicationId;
	}

	public int getDependantId() {
		return dependantId;
	}
	

}
