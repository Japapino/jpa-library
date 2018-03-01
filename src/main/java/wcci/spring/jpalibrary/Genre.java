package wcci.spring.jpalibrary;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	@Id
	@GeneratedValue
	private long id; 
	
	
	@OneToMany(mappedBy = "genre")
	private Collection<Book> books; 
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

	public Collection<Book> getBooks() {
		
		return books;
	}


}
