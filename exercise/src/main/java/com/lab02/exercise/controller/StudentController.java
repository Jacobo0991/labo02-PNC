package com.lab02.exercise.controller;

import com.lab02.exercise.entities.Student;
import com.lab02.exercise.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Obtener todos los estudiantes
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Buscar estudiantes por nombre completo exacto (ejemplo: /students/by-name?name=Paola Perz)
    @GetMapping("/search/by-name")
    public ResponseEntity<List<Student>> getByFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        List<Student> students = studentRepository.findByFirstNameAndLastName(firstName, lastName);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(students);
        }
    }

    //Buscar estudiantes por primer nombre
    @GetMapping("/search/byFirstName")
    public ResponseEntity<List<Student>> getByFirstName(@RequestParam String firstName) {
        List<Student> students = studentRepository.findByFirstName(firstName);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(students);
        }
    }

    //Buscar estudiante por apellido
    @GetMapping("/search/byLastName")
    public ResponseEntity<List<Student>> getByLastName(@RequestParam String lastName) {
        List<Student> students = studentRepository.findUserByLastName(lastName);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(students);
        }
    }

    //Buscar estudiante por carnet
    @GetMapping("/search/byCarnet")
    public ResponseEntity<Student> getStudentsByCarnet(@RequestParam String carnet) {
        Student student = studentRepository.findByCarnet(carnet);
        if (student != null) {
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar estudiante por email
    @GetMapping("/search/byEmail")
    public ResponseEntity<Student> getByEmail(@RequestParam String email) {
        Student student = studentRepository.findUserByEmail(email);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

