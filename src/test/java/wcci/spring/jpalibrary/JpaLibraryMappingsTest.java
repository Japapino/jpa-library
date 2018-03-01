package wcci.spring.jpalibrary;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaLibraryMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private GenreRepository genreRepo;

	@Resource
	private BookRepository bookRepo;
	
	@Resource
	private AuthorRepository authorRepo; 

	@Test
	public void shouldSaveAndLoadCourse() {
		Genre genre = new Genre("genre name");
		genre = genreRepo.save(genre);
		long genreId = genre.getId();

		entityManager.flush();
		entityManager.clear();

		genre = genreRepo.findOne(genreId);

		assertThat(genre.getGenre(), is("genre name"));
	}

	@Test
	public void shouldSaveTextbookToCourseRelationship() {
		Genre genre = new Genre("its name");

		genreRepo.save(genre);
		long genreId = genre.getId();

		Book test = new Book("TEST", genre);
		bookRepo.save(test);
		Book test2 = new Book("TEST2", genre);
		bookRepo.save(test2);

		entityManager.flush();
		entityManager.clear();

		genre = genreRepo.findOne(genreId);
		assertThat(genre.getBooks(), containsInAnyOrder(test, test2));
	}
	
	@Test
	public void shouldSaveAndLoadAuthor() {
		Author author = authorRepo.save(new Author("fname","lname")); 
		long authorId = author.getId(); 
		
		entityManager.flush(); 
		entityManager.clear(); 
		
		author = authorRepo.findOne(authorId); 
		assertThat(author.getFirstName(), is("fname")); 
	}
	
	@Test
	public void shouldEstablishBookAuthorsRelationships() {
		Genre genre = genreRepo.save(new Genre("TEST"));
		
		Author first = authorRepo.save(new Author("test","author")); 
		Author second = authorRepo.save(new Author("test2","author2")); 
		
		Book book = new Book("testBook",genre,first,second); 
		bookRepo.save(book);
		long bookId = book.getId(); 
		
		entityManager.flush();
		entityManager.clear();
		
		book = bookRepo.findOne(bookId); 
		assertThat(book.getAuthors(),containsInAnyOrder(first,second));
	}
	
	@Test
	public void shouldEstablishAuthorBooksRelationships() {
		Genre genre = genreRepo.save(new Genre("TEST"));
		
		Author first = authorRepo.save(new Author("test","author")); 
		
		Book book = new Book("testBook",genre,first); 
		Book book2 = new Book("testBook2",genre,first);
		bookRepo.save(book);
		bookRepo.save(book2); 
		
		long authorId = first.getId(); 
		
		entityManager.flush();
		entityManager.clear();
		
		first = authorRepo.findOne(authorId); 
		assertThat(first.getBooks(),containsInAnyOrder(book, book2));
	
	}


}
