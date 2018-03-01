package wcci.spring.jpalibrary;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue
	private long id; 
	
	private String firstName;
	private String lastName; 
	
	@ManyToMany(mappedBy = "author")
	private Collection<Book> books; 
	
	public long getId() {
		return id; 
	}
	
	public String getFirstName() {
		return firstName; 
	}
	
	public String getLastName() {
		return lastName; 
	}
	
	public Collection<Book> getBooks(){
		return books; 
	}
	
	@SuppressWarnings("unused")
	private Author() {
	}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName; 
	}
	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; 
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Author) obj).id;
	}
	
}
