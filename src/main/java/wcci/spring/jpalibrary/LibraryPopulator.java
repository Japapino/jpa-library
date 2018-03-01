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
		fiction = genreRepo.save(fiction); 
		nonfiction = genreRepo.save(nonfiction); 
		
		Book headfirstjava = new Book("Head First Java",nonfiction); 
		Book sqltables = new Book("SQL Tables",nonfiction); 
		
		bookRepo.save(new Book("Head First Java",nonfiction));
		bookRepo.save(new Book("SQL Tables",nonfiction));
	}
	
	

}
