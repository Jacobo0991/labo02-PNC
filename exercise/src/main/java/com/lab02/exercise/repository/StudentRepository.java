package com.lab02.exercise.repository;


import com.lab02.exercise.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {

    //Buscar por nombre exacto (Query derivada)
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //Buscar por Primer Nombre
    List<Student> findByFirstName(String firstName);

    //Busqueda mediante query para buscar por apellido
    @Query("SELECT u FROM Student u WHERE u.lastName = :lastName")
    List<Student> findUserByLastName(@Param("lastName") String lastName);

    //Buscar por Carnet
    Student findByCarnet(String carnet);

    //Busqueda mediante query para buscar por email
    @Query("SELECT u FROM Student u WHERE u.email = :email")
    Student findUserByEmail(@Param("email") String email);

}


