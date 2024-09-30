package com.cinema.movies.unit

import com.cinema.movies.model.mapper.toEntity
import com.cinema.movies.model.mapper.toResponse
import com.cinema.movies.utils.TestUtils
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MovieMapperTest {

    @Test
    fun whenMovieToResponse_thenReturnMovieResponse() {
        val movie = TestUtils.getMovie()
        val response = movie.toResponse();

        assertEquals(movie.id, response.id)
        assertEquals(movie.rating, response.rating)
        assertEquals(movie.title, response.title)
        assertEquals(movie.releaseYear, response.releaseYear)


    }

    @Test
    fun whenMovieResponseToEntity_thenReturnMovie() {
        val movieResponse = TestUtils.getMovieResponse()
        val response = movieResponse.toEntity();

        assertEquals(movieResponse.id, response.id)
        assertEquals(movieResponse.rating, response.rating)
        assertEquals(movieResponse.title, response.title)
        assertEquals(movieResponse.releaseYear, response.releaseYear)


    }
}