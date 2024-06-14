package com.example.Leccion.repository

import org.springframework.stereotype.Repository
import com.example.Leccion.entity.CharactersView
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface CharactersViewRepository: JpaRepository<CharactersView, Long> {
    fun findById(id: Long?): CharactersView?
}