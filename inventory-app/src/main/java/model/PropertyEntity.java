package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Entity")
public class PropertyEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "property_entity_id", unique = true, nullable = false)
	private int PropertyEntityId;
	
	@Column(name = "property_entity_name", unique = false, nullable = false)
	private String PropertyEntityName;
		
	@ManyToOne
	@JoinColumn(name = "application_id", updatable = false, insertable = false, referencedColumnName = "id")
	protected Application application;
}
