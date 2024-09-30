package com.cinema.movies.utils

import com.cinema.movies.model.Movie
import com.cinema.movies.model.dto.MovieResponse
import com.cinema.movies.model.mapper.toResponse

class TestUtils {


    companion object {

        const val ID = 1L;
        const val TITLE = "test";
        const val RELEASE_YEAR = 2024;
        const val RATING = 5.5;

        fun getMovie(): Movie {
            return Movie(ID, TITLE, RELEASE_YEAR, RATING)
        }

        fun getMovieResponse(): MovieResponse {
            return MovieResponse(ID, TITLE, RELEASE_YEAR, RATING)
        }

        fun getMovies(): List<Movie> {
            return listOf(getMovie())
        }

        fun getMoviesMapped(): List<MovieResponse> {
            return getMovies().map { it.toResponse() }
        }
    }

}