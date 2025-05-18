package com.lab02.exercise.repository;

import com.lab02.exercise.entities.Book;
import com.lab02.exercise.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lab02.exercise.entities.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    //Obtener un préstamo
    Loan findById(long id);

    // Obtener los préstamos de un estudiante
    List<Loan> findByStudent(Student student);

    // Obtener el préstamo de un libro
    @Query("SELECT l FROM Loan l WHERE l.book = :book")
    Loan findByBook(@Param("book") Book book);

    // Obtener préstamos por fecha de regreso
    List<Loan> findByReturnDate(@Param("returnDate") LocalDate returnDate);

    // Obtener préstamos por fecha de préstamo
    @Query("SELECT l FROM Loan l WHERE l.loanDate = :loanDate")
    List<Loan> findByLoanDate(@Param("loanDate") LocalDate loanDate);
}
