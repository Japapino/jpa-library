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

}
