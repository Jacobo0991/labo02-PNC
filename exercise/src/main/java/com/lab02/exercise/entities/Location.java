package com.lab02.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Piso de la biblioteca
    @Column(nullable = false)
    private int floor;

    // Estanteria
    @Column(nullable = false)
    private int shelf;

    // Nivel de la estantería
    @Column(nullable = false)
    private int level;

    // Libro
    @OneToOne(mappedBy = "location")
    private Book book;

    // Constructor
    public Location() {}
    public Location(int floor, int shelf, int level) {
        this.floor = floor;
        this.shelf = shelf;
        this.level = level;
    }

    // Getters y Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }
    public int getShelf() { return shelf; }
    public void setShelf(int shelf) { this.shelf = shelf; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}
