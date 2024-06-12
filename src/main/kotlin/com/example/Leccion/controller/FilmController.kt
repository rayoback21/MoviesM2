package com.example.Leccion.controller

import com.example.Leccion.entity.Film
import com.example.Leccion.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/film")
class FilmController {
    @Autowired
    lateinit var filmService: FilmService

    @GetMapping
    fun  list(): List<Film>{
        return filmService.list()
    }

    @PostMapping
    fun save(@RequestBody film: Film): Film {
        return filmService.save(film)
    }

    @PutMapping
    fun update(@RequestBody film: Film): ResponseEntity<Film> {
        return ResponseEntity(filmService.update(film), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody film: Film): ResponseEntity<Film> {
        return ResponseEntity(filmService.updateDirector(film), HttpStatus.OK)
    }

    @DeleteMapping
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        filmService.delete(id)
        return ResponseEntity("Film deleted", HttpStatus.OK)
    }
}