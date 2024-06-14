package com.example.Leccion.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class FilmView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var title: String? = null
    var director: String? = null
    var duration: Double? = null
    @Column(name = "release_date", nullable = false)
    val releaseDate: LocalDate? = null
    var genre: String? = null
    @Column(name = "box_Office")
    var boxOffice: Double? = null
    var rating: Double? = null
    var summary: String? = null
}