package com.cinema.movies.unit

import com.cinema.movies.model.Movie
import com.cinema.movies.repository.MovieRepository
import com.cinema.movies.utils.TestUtils
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class MovieRepositoryUnitTest {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var movieRepository: MovieRepository;

    val movies: List<Movie> = TestUtils.getMovies();

    @Test
    fun whenFindAll_ThenReturnMovies() {
        movies.forEach { movie -> entityManager.persist(movie) }
        entityManager.flush()

        val response = movieRepository.findAll();

        response.forEach { movie -> Assertions.assertThat(movies.contains(movie)) }


    }
}