package com.example.Leccion.service

import com.example.Leccion.entity.Film
import com.example.Leccion.repository.FilmRepository


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class FilmService {
    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list(): List<Film>{
        return filmRepository.findAll()
    }



    fun save(film: Film): Film{
        return filmRepository.save(film)
    }
    fun update(film: Film): Film{
        try {
            filmRepository.findById(film.id)?: throw Exception("Film no Encontrado")
            return filmRepository.save(film)
        }catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateDirector(film: Film): Film{
        try {

            var response =filmRepository.findById(film.id) ?: throw Exception("Ya existe este ID")
            response.apply {
                director=film.director
            }

            return filmRepository.save(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long){
        try {
            var response =filmRepository.findById(id).orElseThrow{throw ResponseStatusException(HttpStatus.NOT_FOUND, "Film no Existe con el Id: $id")}
            filmRepository.delete(response)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el film",ex)
        }

    }
}