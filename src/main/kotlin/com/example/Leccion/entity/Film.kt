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
    var duration: String? = null
    var releaseDate: String? = null
    var genre: String? = null
    var boxoffice: String? = null
    var rating: String? = null
    var summary: String? = null
}