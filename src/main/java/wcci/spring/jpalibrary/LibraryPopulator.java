package wcci.spring.jpalibrary;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LibraryPopulator implements CommandLineRunner{
	@Resource
	private BookRepository bookRepo;
	@Resource
	private GenreRepository genreRepo; 
	@Resource
	private AuthorRepository authorRepo; 
	
	@Override
	public void run(String... args) throws Exception{
		Genre fiction = new Genre("Fiction"); 
		Genre nonfiction = new Genre("Non-Fiction");
		
//		Book headfirstjava = new Book("Head First Java"); 
//		Book sqltables = new Book("SQL Tables"); 
//		
//		bookRepo.save(new Book("Head First Java"));
//		bookRepo.save(new Book("SQL Tables"));
	}
	
	

}
