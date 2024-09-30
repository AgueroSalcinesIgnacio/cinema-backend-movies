package com.cinema.movies.unit

import com.cinema.movies.model.dto.MovieResponse
import com.cinema.movies.utils.TestUtils
import io.mockk.InternalPlatformDsl.toStr
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class DTOsTest {

    @Test
    fun whenDTOToString_thenReturnString() {
        val movie = MovieResponse();

        assertNotNull(movie.toStr())
    }

    @Test
    fun whenMovieResponseSet_thenReturnDTOFilled() {
        val movie = MovieResponse();
        movie.rating = TestUtils.RATING;
        movie.id = TestUtils.ID;
        movie.title = TestUtils.TITLE;
        movie.releaseYear = TestUtils.RELEASE_YEAR;

        assertEquals(movie.rating, TestUtils.RATING)
        assertEquals(movie.id, TestUtils.ID)
        assertEquals(movie.title, TestUtils.TITLE)
        assertEquals(movie.releaseYear, TestUtils.RELEASE_YEAR)
    }

    @Test
    fun whenMovieResponseGet_thenReturnDTOFilled() {
        val movie = TestUtils.getMovieResponse()

        assertEquals(movie.rating, TestUtils.RATING)
        assertEquals(movie.id, TestUtils.ID)
        assertEquals(movie.title, TestUtils.TITLE)
        assertEquals(movie.releaseYear, TestUtils.RELEASE_YEAR)
    }
}