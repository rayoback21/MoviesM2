package com.example.Leccion.controller

import com.example.Leccion.service.CharactersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.example.Leccion.entity.Characters

@RestController
@RequestMapping("/characters")
class CharactersController {
    @Autowired
    lateinit var charactersService: CharactersService

    @GetMapping
    fun  list(): List<Characters>{
        return charactersService.list()
    }

    @PostMapping
    fun save(@RequestBody characters: Characters): Characters {
        return charactersService.save(characters)
    }

    @PutMapping
    fun update(@RequestBody characters: Characters): ResponseEntity<Characters> {
        return ResponseEntity(charactersService.update(characters), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody characters: Characters): ResponseEntity<Characters> {
        return ResponseEntity(charactersService.updateDescription(characters), HttpStatus.OK)
    }

    @DeleteMapping
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        charactersService.delete(id)
        return ResponseEntity("Characters deleted", HttpStatus.OK)
    }
}
