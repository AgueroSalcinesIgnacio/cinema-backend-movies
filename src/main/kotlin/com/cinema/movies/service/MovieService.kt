package com.cinema.movies.service

import com.cinema.movies.model.dto.MovieResponse

interface MovieService {
    fun getMovies(): List<MovieResponse>
}