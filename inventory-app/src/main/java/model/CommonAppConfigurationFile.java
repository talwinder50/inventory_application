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
@Table(name = "Common_App_Config_Files")
public class CommonAppConfigurationFile {
	
/*
lookup table manually loaded	
@application_id= 	foreign key with application_instance table 
@config_name = example cds.properties csp-bt.properties 
@propertkeys = It will ; separated  and manually loaded

*/
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "common_config_id", unique = false, nullable = false) 
	private int commonConfigId;
	
	@Column(name = "config_file_type", unique = false, nullable = false) 
	private String configFileType;
	
	@Column(name = "config_name", unique = false, nullable = false) 
	private String configName;
	
	@Column(name = "property_keys", unique = false, nullable = false) 
	private String propertiesKeys;
	
	@Column(name = "application_id", unique = false, nullable = false) 
	private int applicationId;
	
	 @ManyToOne
	 @JoinColumn(name = "application_id", updatable = false, insertable = false, referencedColumnName = "application_id")
     protected Application application;

	public int getCommonConfigId() {
		return commonConfigId;
	}

	public void setCommonConfigId(int commonConfigId) {
		this.commonConfigId = commonConfigId;
	}

	public String getConfigFileType() {
		return configFileType;
	}

	public void setConfigFileType(String configFileType) {
		this.configFileType = configFileType;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}
	
	
}
