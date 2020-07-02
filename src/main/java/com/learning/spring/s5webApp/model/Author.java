package com.learning.spring.s5webApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String firstName;
    private String secondName;

    //Set up a many-to-many relationship on the books property
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books =  new HashSet<>();

    public Author(){}  //empty constructor required for JPA


    public Author(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
//        this.books = books;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Id == author.Id;
    }

    @Override
    public int hashCode() {
        return (int) (Id ^ (Id >>> 32));
    }
}

