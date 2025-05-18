package com.lab02.exercise.repository;

import com.lab02.exercise.entities.Book;
import com.lab02.exercise.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    //Buscar por titulo
    List<Book> findByTitle(String title);

    //Buscar todods los libros de un autor por nombre completo
    @Query("SELECT b FROM Book b WHERE b.author.firstName = :firstName AND b.author.lastName = :lastName")
    List<Book> findBooksByAuthorFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    //Buscar todos los libros de un autor por su apelllido
    @Query("SELECT b FROM Book b WHERE b.author.lastName = :lastName")
    List<Book> findBooksByAuthorLastName(@Param("lastName") String lastName);

    //Buscar libro en ubicacion especifica
    @Query("SELECT b FROM Book b WHERE b.location.floor = :floor AND b.location.shelf = :shelf AND b.location.level = :level")
    List<Book> findByLocationDetails(@Param("floor") int floor,
                                     @Param("shelf") int shelf,
                                     @Param("level") int level);


}
