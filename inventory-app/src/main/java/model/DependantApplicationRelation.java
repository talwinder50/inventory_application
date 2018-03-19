package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@IdClass(DependentRelationID.class)
/*
 * Table Defination: This is relation ship table between application and its dependencies . 
 * Manual update. Obsolete for now 
 *  @applicationId Fk Auto generated in application table
 *  @dependancyId Fk Auto generated in Dependency table
*/
@Table(name = "Dependant_Relation")
public class DependantApplicationRelation {
	
	@Id
	@Column(name = "dependancy_id", unique = false, nullable = false) 
	private int dependancyId;
	
	@Id
	@Column(name = "application_id", unique = false, nullable = false) 
	private int applicationId;
		
	@ManyToOne
	@JoinColumn(name = "application_id", updatable = false, insertable = false, referencedColumnName = "application_id")
	protected Application applications;
	

}
