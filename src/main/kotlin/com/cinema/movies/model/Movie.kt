package com.cinema.movies.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "movies")
data class Movie(
    @Id
    @Column(name = "id") var id: Long,
    @Column(name = "title") var title: String?,
    @Column(name = "release_year") var releaseYear: Int?,
    @Column(name = "rating") var rating: Double?
)