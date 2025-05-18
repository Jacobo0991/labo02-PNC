package com.lab02.exercise.repository;

import com.lab02.exercise.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    //Buscar autor por nombre
    @Query("SELECT a FROM Author a WHERE a.firstName = :firstName")
    List<Author> findByFirstName(@Param("firstName") String firstName);

    //Por apellido
    @Query("SELECT a FROM Author a WHERE a.lastName = :lastName")
    List<Author> findByLastName(@Param("lastName") String lastName);

    //Buscar autores por nombre completo
    Author findByFirstNameAndLastName(String firstName, String lastName);



}
