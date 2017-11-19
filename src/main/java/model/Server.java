package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "server")
public class Server implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
    
    @Id
	@Column(name = "server_name",unique=true, nullable = false, length = 180)
	private String serverName;
    @Column(name = "Responsible_Manager")
    private String  managerName;
    
   

	private String enviornment;

	@Column(name = "tier",nullable = false, length = 60)
	private String tier;
    
	@Column(name = "type",nullable = false, length = 60)
	//@Enumerated(EnumType.STRING) type type1;
	//enum type { WIN,LINUX,DB,LPAR }; 
	private String type;
	
	 @Column(name = "cpu_count",nullable = false, length = 60)
		private Integer cpu_count;
	
	@Column(name = "ram_allocated",nullable = false, length = 60)
	private String ram_allocated;
	
	private String server_jboss_version;
	
	@Column(name = "patchingCycle",nullable = false, length = 60)
	private String patchingCycle;

	public Server() {
	}

	public String getserverName() {
		return serverName;
	}

	public void setserverName(String server_name) {
		this.serverName = server_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
     
	
	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public Integer getCpu_count() {
		return cpu_count;
	}

	public void setCpu_count(Integer cpu_count) {
		this.cpu_count = cpu_count;
	}

	public String getRam_allocated() {
		return ram_allocated;
	}

	public void setRam_allocated(String ram_allocated) {
		this.ram_allocated = ram_allocated;
	}
	
	 public String getManagerName() {
			return managerName;
		}

		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}

	public Server(String server_name,String Responsible_manager, String type,String ram_allocated,int cpu_count,String jboss_version,String tier) 
	{
		this.serverName = server_name;
		this.managerName =Responsible_manager;
		this.type = type;
		this.ram_allocated=ram_allocated;
		this.cpu_count=cpu_count;
		this.tier =tier;
		

	}

	

	public String getEnviornment() {
		return enviornment;
	}

	public void setEnviornment(String enviornment) {
		this.enviornment = enviornment;
	}

	public String getServer_jboss_version() {
		return server_jboss_version;
	}

	public void setServer_jboss_version(String server_jboss_version) {
		this.server_jboss_version = server_jboss_version;
	}
}
