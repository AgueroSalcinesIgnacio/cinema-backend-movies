package com.cinema.movies.unit

import com.cinema.movies.model.Movie
import com.cinema.movies.utils.TestUtils
import io.mockk.InternalPlatformDsl.toStr
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class EntitiesTest {

    @Test
    fun whenEntityToString_thenReturnString() {
        val movie = Movie();

        assertNotNull(movie.toStr())
    }


    @Test
    fun whenMovieSet_thenReturnDTOFilled() {
        val movie = Movie();
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
    fun whenMovieGet_thenReturnDTOFilled() {
        val movie = TestUtils.getMovie()

        assertEquals(movie.rating, TestUtils.RATING)
        assertEquals(movie.id, TestUtils.ID)
        assertEquals(movie.title, TestUtils.TITLE)
        assertEquals(movie.releaseYear, TestUtils.RELEASE_YEAR)
    }
}