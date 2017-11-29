package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Dependant_Relation")
public class DependantApplicationRelation {
	
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "dependant_id", unique = true, nullable = false) 
	private int dependantId;
	
	@Column(name = "application_name", unique = false, nullable = true)
	private String applicationName;
	
	@Column(name = "dependant_name", unique = false, nullable = true)
	private String dependantName;
	
	@OneToMany(mappedBy = "applicationName")
    private List<Application> applications;
	

	public String getDependantName() {
		return dependantName;
	}

	public void setDependantName(String dependantName) {
		this.dependantName = dependantName;
	}
	
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	public int getDependantId() {
		return dependantId;
	}

	public void setDependantId(int dependantId) {
		this.dependantId = dependantId;
	}

}
