package com.cinema.movies.controller

import com.cinema.movies.model.dto.MovieResponse
import com.cinema.movies.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MovieController(private val movieService: MovieService) {
    @GetMapping
    fun getMovies(): List<MovieResponse> {
        return movieService.getMovies()
    }
}