package com.lab02.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Título del libro
    @Column(nullable = false)
    private String title;

    // Autor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    // Ubicación
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Location location;

    //Constructor
    public Book() { }
    public Book(String title) {
        this.title = title;
    }

    //Getters y setters
    public long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

}