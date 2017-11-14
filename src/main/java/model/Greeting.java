package model;

//@Entity
//@Table(name="Greeting")
public class Greeting {

//	@Id
//	@Column(name="id")
    private long id;
	
//	@Column
    private String content;
    
//	@Column
	private String Gender;
    
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;      
    }


    public Greeting(long id, String content,String Gender) {
        this.id = id;
        this.content = content;
        this.Gender=Gender;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

	public String getGender() {		
		return Gender;
	}
}
