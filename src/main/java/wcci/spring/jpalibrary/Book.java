package wcci.spring.jpalibrary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private long id; 
	
//	private Author author; 
	private String title;
	private String java; 
	@ManyToOne
	private Genre genre; 
	
	private Book() {
		
	}
	
	public Book(String title, Genre genre) {
		this.title = title; 
		this.genre = genre; 
	}
	
	
	public long getId() {
		return id; 
	}
	
	public Genre getGenre() {
		return genre;
	}
	
//	public Author getAuthor() {
//		return this.author; 
//	}
	
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
