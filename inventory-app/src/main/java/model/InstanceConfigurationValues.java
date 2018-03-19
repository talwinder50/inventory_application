package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "Configuration_Values")
public class InstanceConfigurationValues {
	
	/*
	 * Table Defination : Values of that specific file key-value pair 
	using the information from instance_configuration_file info connection from 
	ssh service will populate this table 	
	@property_key =properties key name 
	@property_value=	property value  in config value
	@config_instance_id =relationship with instance_configuration_file table fk 	
	*/
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "config_value_id", unique = true, nullable = false)
		private int ConfigValueId;
		
		@Column(name = "property_key", unique = false, nullable = false)
		private String PropertyKey;
		
		@Column(name = "property_value", unique = false, nullable = false)
		private String PropertyValue;
		
		@Column(name = "modified_date")
	    @LastModifiedDate
	    private long modifiedDate;
		
		 @ManyToOne
		 @JoinColumn(name = "config_instance_id", updatable = false, insertable = false, referencedColumnName = "config_instance_id")
	     protected InstanceConfigurationFile instanceConfigurationFile;

		 public int getConfigValueId() {
				return ConfigValueId;
			}

			public void setConfigValueId(int configValueId) {
				ConfigValueId = configValueId;
			}

			public String getPropertyKey() {
				return PropertyKey;
			}

			public void setPropertyKey(String propertyKey) {
				PropertyKey = propertyKey;
			}

			public String getPropertyValue() {
				return PropertyValue;
			}

			public void setPropertyValue(String propertyValue) {
				PropertyValue = propertyValue;
			}
		
	}

