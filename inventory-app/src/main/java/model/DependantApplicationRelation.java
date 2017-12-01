package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  @IdClass(DependentRelationID.class)

@Table(name = "Dependant_Relation")
public class DependantApplicationRelation {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "dependant_id", unique = false, nullable = false) 
	private int dependantId;
	
	@Id 
	@Column(name = "application_id", unique = false, nullable = false) 
	private int applicationId;
		
	@ManyToOne
	@JoinColumn(name = "dependant_id", updatable = false, insertable = false, referencedColumnName = "id")
	protected Application applications;
	
	public int getDependantId() {
		return dependantId;
	}

	public void setDependantId(int dependantId) {
		this.dependantId = dependantId;
	}

}
