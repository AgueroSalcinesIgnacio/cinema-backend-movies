package com.cinema.movies.model.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Getter
import lombok.Setter
import lombok.ToString

@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
data class MovieResponse(
    var id: Long? = null,
    var title: String? = null,
    var releaseYear: Int? = null,
    var rating: Double? = null
)

