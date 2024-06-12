package com.example.Leccion.repository

import com.example.Leccion.entity.Scene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SceneRepository: JpaRepository<Scene, Long>{
  fun findById(id:Long?): Scene?
}