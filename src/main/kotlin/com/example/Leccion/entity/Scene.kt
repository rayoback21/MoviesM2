package com.example.Leccion.entity

import jakarta.persistence.*

@Entity
@Table(name = "scene")
class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var budget: Double? = null
    var minutes: Number? = null
    @Column(name = "film_id")
    var filmId: String? = null
}