package com.example.Leccion.entity

import jakarta.persistence.*

@Entity
@Table(name = "characters_view")

class CharactersView {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "full_name")
    var fullName: String? = null
    var description: String? = null
    var cost: Double? = null
    var actor: String? = null
    var stock: String? = null
    var rol: String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scene_id")
    var scene: Scene? = null

}