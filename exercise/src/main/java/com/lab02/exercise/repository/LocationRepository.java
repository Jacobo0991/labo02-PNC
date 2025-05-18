package com.lab02.exercise.repository;

import com.lab02.exercise.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lab02.exercise.entities.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    //Buscar por piso
    List<Location> findByFloor(int floor);

    //Buscar por piso y estantería
    @Query("SELECT l FROM Location l WHERE l.floor = :floor AND l.shelf = :shelf")
    List<Location> findByLevelShelf(@Param("floor") int floor, @Param("shelf") int shelf);
}
