package com.lab02.exercise.controller;

import com.lab02.exercise.entities.Author;
import com.lab02.exercise.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //Obtener todos los libros
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    //Buscar autor por nombre (ejemplo: /authors/search/by-first-name?name=Stephen)
    @GetMapping("/search/by-first-name")
    public ResponseEntity<List<Author>> getByFirstName(@RequestParam String firstName) {
        List<Author> authors = authorRepository.findByFirstName(firstName);
        if (authors.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(authors);
        }
    }

    //Buscar autor por nombre completo (ej. /authors/search/by-fullname?firstName=Stephen&lastName=King)
    @GetMapping("/search/by-fullname")
    public ResponseEntity<Author> getAuthorByFullName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        Author author = authorRepository.findByFirstNameAndLastName(firstName, lastName);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(author);
        }
    }


    //Buscar autor por su apellido (ejemplo: /authors/search/by-lastname?lastName=King)
    @GetMapping("/search/by-lastname")
    public ResponseEntity<List<Author>> getByLastName(@RequestParam String lastName) {
        List<Author> authors = authorRepository.findByLastName(lastName);
        if (authors.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(authors);
        }
    }
}
