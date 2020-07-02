package com.learning.spring.s5webApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String publisherName;
    private int yearOfIncorporation;
    private String city;
    private String country;

    @OneToMany
    @JoinColumn(name = "publisher_id")  //telling hibernate to add publisher ID to a book
    private Set<Book> books = new HashSet<>();

    public Publisher(){};

    public Publisher(long id, String publisherName, int yearOfIncorporation, String city, String country) {
        Id = id;
        this.publisherName = publisherName;
        this.yearOfIncorporation = yearOfIncorporation;
        this.city = city;
        this.country = country;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getYearOfIncorporation() {
        return yearOfIncorporation;
    }

    public void setYearOfIncorporation(int yearOfIncorporation) {
        this.yearOfIncorporation = yearOfIncorporation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + Id +
                ", publisherName='" + publisherName + '\'' +
                ", yearOfIncorporation=" + yearOfIncorporation +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Id == publisher.Id;
    }

    @Override
    public int hashCode() {
        return (int) (Id ^ (Id >>> 32));
    }
}
