package com.example.Leccion.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class SceneView (
    @Id
    @Column(name ="scene_id")
    val sceneId : Long,

    @Column(name = "scene_description")
    val sceneDescription : String,

    @Column(name = "minutes")
    val minutes : BigDecimal,

    @Column(name = "scene_place")
    val scenePlace : String,

    @Column(name = "budget")
    val budget : BigDecimal,

    @Column(name = "film_title")
    val filmTitle : String,
)