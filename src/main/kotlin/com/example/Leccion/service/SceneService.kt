package com.example.Leccion.service

import com.example.Leccion.entity.Scene
import com.example.Leccion.repository.FilmRepository
import com.example.Leccion.repository.SceneRepository
import com.example.Leccion.repository.SceneViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SceneService {

    @Autowired
    lateinit var sceneViewRepository: SceneViewRepository

    @Autowired
    lateinit var sceneRepository: SceneRepository

    @Autowired
    lateinit var filmRepository: FilmRepository


    fun list(): List<Scene> {
        return sceneRepository.findAll()
    }

    fun save(scene: Scene): Scene {
        val filmId = scene.film?.id ?: throw Exception("Film ID is required")
        val scenes = sceneRepository.findByFilmId(filmId)
        val film = filmRepository.findById(filmId).orElseThrow { Exception("Film not found") }

        val totalMinutes = scenes.sumByDouble { it.minutes?.toDouble() ?: 0.0 }

        if ((totalMinutes + (scene.minutes?.toDouble() ?: 0.0)) > (film.duration?.toDouble() ?: 0.0)) {
            throw Exception("El total de minutos alcanzado")
        }
        return sceneRepository.save(scene)
    }

    fun update(scene: Scene): Scene {
        try {
            sceneRepository.findById(scene.id) ?: throw Exception("Scene ID is required")
            return sceneRepository.save(scene)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateBudget(scene: Scene): Scene {
        try {
            val response = sceneRepository.findById(scene.id) ?: throw Exception("Ya existe el ID")
            response.apply {
                budget = scene.budget
            }
            return sceneRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        try {
            val response = sceneRepository.findById(id)
                .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Escena no existe en del Id: $id") }
            sceneRepository.delete(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al Eliminar la Escena", ex)
        }
    }
}
