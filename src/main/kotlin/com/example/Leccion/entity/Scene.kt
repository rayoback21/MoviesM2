package com.example.Leccion.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "scene")
class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var budget: Double? = null
    var minutes: Double? = null
    @Column(name = "scene_place")
    var scenePlace: String? = null
    @Column(name = "date_shot")
    var dateShot: LocalDate? = null
    var actors: String? = null
    @Column(name = "scene_type")
    var sceneType: String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    var film: Film? = null
}