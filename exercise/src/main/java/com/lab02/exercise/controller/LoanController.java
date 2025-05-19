package com.lab02.exercise.controller;

import com.lab02.exercise.entities.Book;
import com.lab02.exercise.entities.Loan;
import com.lab02.exercise.entities.Student;
import com.lab02.exercise.repository.BookRepository;
import com.lab02.exercise.repository.LoanRepository;
import com.lab02.exercise.repository.StudentRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanRepository loanRepository;
    private StudentRepository studentRepository;
    private BookRepository bookRepository;

    public LoanController(LoanRepository loanRepository, StudentRepository studentRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    //Obtener todos los prestamos
    @GetMapping
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    //Buscar un prestamo por ID (ejemplo: localhost:8080/loans/by-id?id=3)
    @GetMapping("/by-id")
    public ResponseEntity<Loan> getLoanById(@RequestParam Long id) {
        return loanRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener préstamos por ID de estudiante (ejemplo: localhost:8080/loans/by-student?studentId=2)
    @GetMapping("/by-student")
    public List<Loan> getLoansByStudent(@RequestParam Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        return student != null ? loanRepository.findByStudent(student) : List.of();
    }

    // Obtener préstamo por ID de libro (ejemplo: localhost:8080/loans/by-book?bookId=3)
    @GetMapping("/by-book")
    public Loan getLoanByBook(@RequestParam Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        return book != null ? loanRepository.findByBook(book) : null;
    }


    // Obtener préstamos por fecha de regreso (ej./loans/by-return-date?returnDate=2024-05-15)
    @GetMapping("/by-return-date")
    public List<Loan> getLoansByReturnDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {
        return loanRepository.findByReturnDate(returnDate);
    }

    // Obtener préstamos por fecha de préstamo (ej./loans/by-loan-date?loanDate=2024-05-01)

    @GetMapping("/by-loan-date")
    public List<Loan> getLoansByLoanDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate loanDate) {
        return loanRepository.findByLoanDate(loanDate);
    }



}
