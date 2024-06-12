package com.example.Leccion.repository

import com.example.Leccion.entity.Film
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FilmRepository : JpaRepository<Film, Long>{
    fun findById(id: Long?): Film?
}

