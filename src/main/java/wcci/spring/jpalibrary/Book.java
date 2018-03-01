package wcci.spring.jpalibrary;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private long id; 
	
	@ManyToMany
	private Collection<Author> author; 
	private String title;
	
	@ManyToOne
	private Genre genre; 
	
	private Book() {
		
	}
	
	public Book(String title, Genre genre, Author...authors) {
		this.title = title; 
		this.genre = genre; 
		this.author = Arrays.asList(authors); 
	}
	


	public long getId() {
		return id; 
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public Collection<Author> getAuthors() {
		return this.author; 
	}
	
	public String getTitle() {
		return title;
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

		return id == ((Book) obj).id;
	}

}
