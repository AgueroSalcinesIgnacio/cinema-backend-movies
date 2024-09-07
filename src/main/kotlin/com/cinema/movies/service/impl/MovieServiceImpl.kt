package com.cinema.movies.service.impl

import com.cinema.movies.model.dto.MovieResponse
import com.cinema.movies.model.mapper.toResponse
import com.cinema.movies.repository.MovieRepository
import com.cinema.movies.service.MovieService
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(private val movieRepository: MovieRepository) : MovieService {
    override fun getMovies(): List<MovieResponse> {
        return movieRepository.findAll().map { it.toResponse() }
    }
}