package com.example.Leccion.repository


import com.example.Leccion.entity.FilmView
import com.example.Leccion.entity.SceneView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SceneViewRepository: JpaRepository<FilmView, Long>{
  fun findById(id:Long?): SceneView?
}