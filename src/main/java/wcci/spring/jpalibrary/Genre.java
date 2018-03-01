package wcci.spring.jpalibrary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {
	@Id
	@GeneratedValue
	private long id; 
	
	private String type; 
	public Genre() {
		
	}
	
	public Genre(String type) {
		this.type = type;  
	}
	
	public String getGenre() {
		return type; 
	}
	
	public Long getId() {
		return id; 
	}

}
