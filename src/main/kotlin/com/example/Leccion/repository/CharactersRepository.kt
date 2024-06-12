package com.example.Leccion.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.Leccion.entity.Characters

@Repository
interface CharactersRepository: JpaRepository<Characters, Long> {
    fun findById (id: Long?) : Characters?

}