package com.example.Leccion.entity

import jakarta.persistence.*

@Entity
@Table(name = "characters")

class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var fullName: String? = null
    var description: String? = null
    var cost: Double? = null
    var actor: String? = null
    var costume: String? = null
    var rol: String? = null
    @Column(name = "scene_id")
    var sceneId: Long? = null
    }