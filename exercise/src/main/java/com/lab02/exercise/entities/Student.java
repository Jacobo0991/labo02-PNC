package com.lab02.exercise.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nombre
    @Column(nullable = false)
    private String firstName;

    //Apellido
    @Column(nullable = false)
    private String lastName;

    // Carnet (unico para cada student)
    @Column(nullable = false, unique = true)
    private String carnet;

    // correo electrónico (único para cada student)
    @Column(nullable = false, unique = true)
    private String email;


    //Constructor
    public Student() {}

    public Student(String firstName, String lastName, String carnet, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.carnet = carnet;
        this.email = email;
    }

    //Getters y Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCarnet() { return carnet; }
    public void setCarnet(String carnet) { this.carnet = carnet; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}