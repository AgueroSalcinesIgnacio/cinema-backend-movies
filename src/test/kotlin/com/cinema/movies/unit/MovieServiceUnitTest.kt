package com.cinema.movies.unit

import com.cinema.movies.model.Movie
import com.cinema.movies.model.mapper.toResponse
import com.cinema.movies.repository.MovieRepository
import com.cinema.movies.service.impl.MovieServiceImpl
import com.cinema.movies.utils.TestUtils
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class MovieServiceUnitTest {
    val movieRepository: MovieRepository = mockk();
    val movieService = MovieServiceImpl(movieRepository);

    val movies: List<Movie> = TestUtils.getMovies();

    @Test
    fun testGetMovies() {

        every { movieRepository.findAll() } returns movies;

        val result = movieService.getMovies();

        verify(exactly = 1) { movieRepository.findAll() }

        val moviesMapped = movies.map { it.toResponse() }
        assertEquals(moviesMapped, result)
    }
}