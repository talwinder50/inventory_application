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
@Table(name = "Application")
public class Application {
	/*
	 * Application  is lookup table 
	 * applicationID - Auto generated
	 * applicationName "example pin/ cds/ crs"
	 * Manual Upadte
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "application_id", unique = true, nullable = false )
	private int applicationID;
	@Column(name = "application_name", unique = true, nullable = false )
	private String applicationName;
	
	@OneToMany(mappedBy = "applicationId")
    private List<DependantApplicationRelation> dependantApplicationRelation;
	
	@OneToMany(mappedBy = "applicationId")
    private List<CommonAppConfigurationFile> commonAppConfigurationFile;

}
