package com.cinema.movies.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.EqualsAndHashCode
import lombok.Getter
import lombok.Setter

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "movies")
data class Movie(
    @Id
    @Column(name = "id") var id: Long? = null,
    @Column(name = "title") var title: String? = null,
    @Column(name = "release_year") var releaseYear: Int? = null,
    @Column(name = "rating") var rating: Double? = null
)