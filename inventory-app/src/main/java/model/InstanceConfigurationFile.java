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
@Table(name = "instance_configuration_files")
public class InstanceConfigurationFile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "config_instance_id", unique = true, nullable = false)
	private int ConfigInstanceId;
	
	
	@Column(name = "config_file_path", unique = false, nullable = false)
	private String ConfigFilePath;
			
	@ManyToOne
	@JoinColumn(name = "application_instance_id", updatable = false, insertable = false, referencedColumnName = "id")
	protected ApplicationInstance applicationInstance;
	
	public int getConfigInstanceId() {
		return ConfigInstanceId;
	}

	public void setConfigInstanceId(int configInstanceId) {
		ConfigInstanceId = configInstanceId;
	}

	public String getConfigFilePath() {
		return ConfigFilePath;
	}

	public void setConfigFilePath(String line) {
		ConfigFilePath = line;
	}

}
