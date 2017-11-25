package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Search_Criteria")
public class SearchCriteria {

	@Id
	@Column(name="id")
    private int id;
	
	@Column
    private String displayName;
	
	public SearchCriteria() {
	}
      
    public SearchCriteria(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;      
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
