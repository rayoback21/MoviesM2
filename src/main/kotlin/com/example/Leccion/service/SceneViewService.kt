package com.example.Leccion.service

import com.example.Leccion.entity.Scene
import com.example.Leccion.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SceneViewService {
    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun list(): List<Scene>{
        return sceneRepository.findAll()
    }
    fun save(scene: Scene): Scene{
        return sceneRepository.save(scene)
    }

    fun update(scene: Scene): Scene  {
        try {

            sceneRepository.findById(scene.id)?:throw Exception("Escena no Encontrada")
            return sceneRepository.save(scene)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun updateBudget(scene: Scene): Scene{
        try {
            var response= sceneRepository.findById(scene.id)?: throw Exception("Ya existe el ID")
            response.apply {
                budget=scene.budget
            }
            return sceneRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun delete(id: Long){
     try {
         var response= sceneRepository.findById(id).orElseThrow{throw ResponseStatusException(HttpStatus.NOT_FOUND,"Escena no existe en del Id: $id")}
         sceneRepository.delete(response)
     }
     catch (ex:Exception){
         throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al Eliminar la Escena", ex)
     }
    }
}