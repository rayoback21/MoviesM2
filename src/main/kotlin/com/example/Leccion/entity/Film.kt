package com.example.Leccion.entity

import jakarta.persistence.*

@Entity
@Table(name = "film")
class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var title: String? = null
    var director: String? = null
    var duration: Double? = null
    @Column(name = "release_date")
    var releaseDate: Long? = null
    var genre: String? = null
    @Column(name = "box_Office")
    var boxOffice: Double? = null
    var rating: Double? = null
    var summary: String? = null
}