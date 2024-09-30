package com.cinema.movies.controller

import com.cinema.movies.model.dto.MovieResponse
import com.cinema.movies.service.MovieService
import com.cinema.users.config.error.exception.GenericException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MovieController(private val movieService: MovieService) {
    @GetMapping
    fun getMovies(): ResponseEntity<List<MovieResponse>> {
        return try {
            ResponseEntity.ok(movieService.getMovies())
        } catch (exception: Exception) {
            throw GenericException(exception.message)
        }

    }
}