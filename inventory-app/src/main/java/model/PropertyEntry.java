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
@Table(name = "Property_Entry")
public class PropertyEntry {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "property_entry_id", unique = true, nullable = false)
		private int PropertyEntryId;
		
		@Column(name = "property_entity_name", unique = false, nullable = false)
		private String PropertyEntityName;
		
		@Column(name = "property_key", unique = true, nullable = false)
		private String PropertyKey;
		
		@ManyToOne
		@JoinColumn(name = "property_type", updatable = false, insertable = false, referencedColumnName = "property_type")
		protected PropertyType propertyType;
	}

