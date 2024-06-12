package com.example.Leccion.service

import com.example.Leccion.repository.CharactersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import com.example.Leccion.entity.Characters


@Service
class CharactersService {
    @Autowired
    lateinit var charactersRepository: CharactersRepository

    fun list(): List<Characters>{
        return charactersRepository.findAll()
    }




    fun save(characters: Characters): Characters {
        return charactersRepository.save(characters)
    }

    fun update(characters: Characters): Characters {
       try {
           charactersRepository.findById(characters.id)?: throw Exception("Characters no Encontrado")

        return charactersRepository.save(characters)
    }catch (ex: Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
}
    fun updateDescription(characters: Characters): Characters {
        try {

            var response = charactersRepository.findById(characters.id) ?: throw Exception("Ya exixte este ID")
            response.apply {
                description=characters.description

            }
            return charactersRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun delete(id: Long) {
        try {
            var response = charactersRepository.findById(id).orElseThrow{throw ResponseStatusException(HttpStatus.NOT_FOUND, "Character no Existe con el Id:  $id")}
            charactersRepository.delete(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al eliminar el character",ex)
        }



    }
}