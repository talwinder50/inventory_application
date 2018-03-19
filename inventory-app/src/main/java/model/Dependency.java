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
@Table(name = "dependency")
public class Dependency {
	/*Table Defination : This is lookup table for dependency. 
	It is superset of application . Manual update. Obsolete for now 
	@dependantId= Auto Generated
	@dependantName= sybase/tv/blob
	*/
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "dependency_id", unique = false, nullable = false) 
	private int dependantId;

	@Column(name = "dependant_name", unique = true, nullable = false) 
	private int dependantName;
	
	@Column(name = "description", unique = false, nullable = false) 
	private int description;
	
	@OneToMany(mappedBy = "dependancyId")
    private List<DependantApplicationRelation> dependant_application;

}
