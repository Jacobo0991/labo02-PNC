package com.lab02.exercise.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Estudiante
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    //libro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    //Fecha prestamo
    @Column(nullable = false)
    private LocalDate loanDate;

    //Fecha de regreso
    @Column
    private LocalDate returnDate;

    //Constructor
    public Loan() {}

    public Loan(LocalDate loanDate, LocalDate returnDate) {
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    // Getters y setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public LocalDate getLoanDate() { return loanDate; }
    public void setLoanDate(LocalDate loanDate) { this.loanDate = loanDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

}


