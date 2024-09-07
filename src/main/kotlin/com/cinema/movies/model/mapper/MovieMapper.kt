package com.cinema.movies.model.mapper

import com.cinema.movies.model.Movie
import com.cinema.movies.model.dto.MovieResponse

fun Movie.toResponse(): MovieResponse {
    return MovieResponse(
        id,
        title,
        releaseYear,
        rating
    )
}

fun MovieResponse.toEntity(): Movie {
    return Movie(
        id,
        title,
        releaseYear,
        rating
    )
}
