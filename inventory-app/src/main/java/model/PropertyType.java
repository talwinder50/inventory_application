package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property_Type")
public class PropertyType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "property_type_id", unique = true, nullable = false)
	private int PropertyTypeId;
	
	@Column(name = "property_type", unique = false, nullable = false)
	private int PropertyType;
	
	@Column(name = "property_value", unique = true, nullable = false)
	private String PropertyValue;

}
