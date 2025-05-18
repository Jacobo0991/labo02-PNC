package com.lab02.exercise.controller;

import com.lab02.exercise.entities.Book;
import com.lab02.exercise.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Obtener todos los libros
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Buscar libro por titulo (ejemplo: /books/search/by-title?title=IT)
    @GetMapping("/search/by-title")
    public ResponseEntity<List<Book>> getByTitle(@RequestParam String title) {
        List<Book> books = bookRepository.findByTitle(title);
        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(books);
        }
    }

    //Buscar todods los libros de un autor por nombre completo (ej. /books/search/by-author-fullname?firstName=Stephen&lastName=King)
    @GetMapping("/search/by-author-fullname")
    public ResponseEntity<List<Book>> getBooksByAuthorFullName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        List<Book> books = bookRepository.findBooksByAuthorFullName(firstName, lastName);
        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(books);
        }
    }


    //Buscar todos los libros de un autor por su apellido (ejemplo: /books/search/by-author-lastname?lastName=King)
    @GetMapping("/search/by-author-lastname")
    public ResponseEntity<List<Book>> getByAuthorLastName(@RequestParam String lastName) {
        List<Book> books = bookRepository.findBooksByAuthorLastName(lastName);
        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(books);
        }
    }

    //Buscar libro en ubicacion especifica (ejemplo: /books/search/by-location?floor=2&shelf=3&level=1)
    @GetMapping("/search/by-location")
    public ResponseEntity<List<Book>> getByLocation(
            @RequestParam int floor,
            @RequestParam int shelf,
            @RequestParam int level) {
        List<Book> books = bookRepository.findByLocationDetails(floor,shelf, level);
        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(books);
        }
    }



}
