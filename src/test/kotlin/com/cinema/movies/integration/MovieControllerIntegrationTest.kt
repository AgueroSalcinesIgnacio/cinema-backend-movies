package com.cinema.movies.integration

import com.cinema.movies.model.dto.MovieResponse
import com.cinema.movies.service.MovieService
import com.cinema.movies.utils.TestUtils
import com.cinema.users.config.error.exception.GenericException
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class MovieControllerIntegrationTest(@Autowired val mockMvc: MockMvc) {
    @MockkBean
    lateinit var movieService: MovieService

    private val movies: List<MovieResponse> = TestUtils.getMoviesMapped();

    @Test
    fun getAllMovies_whenGetRequest_thenReturnsMoviesWithStatus200() {
        every { movieService.getMovies() } returns movies;

        mockMvc.perform(get("/movies"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(TestUtils.ID))
            .andExpect(jsonPath("$[0].title").value(TestUtils.TITLE))
            .andExpect(jsonPath("$[0].rating").value(TestUtils.RATING))
            .andExpect(jsonPath("$[0].releaseYear").value(TestUtils.RELEASE_YEAR));
    }

    @Test
    fun getAllMovies_whenGetRequest_thenReturnsExceptionWithStatus400() {
        every { movieService.getMovies() } throws GenericException("test");

        mockMvc.perform(get("/movies"))
            .andExpect(status().isBadRequest);
    }
}