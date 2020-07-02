package com.learning.spring.s5webApp.bootstrap;

import com.learning.spring.s5webApp.model.Author;
import com.learning.spring.s5webApp.model.Book;
import com.learning.spring.s5webApp.model.Publisher;
import com.learning.spring.s5webApp.repositories.AuthorRepository;
import com.learning.spring.s5webApp.repositories.BookRepository;
import com.learning.spring.s5webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  //This annotation tells the compiler that its a spring managed component
public class BootStrapData implements CommandLineRunner {

    //define two properties
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository
                            ,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Victorian");
        publisher.setYearOfIncorporation(1955);
        publisher.setCity("St. Petersburg");
        publisher.setCountry("Russia");
        publisherRepository.save(publisher);

        Author dostoyevsky  = new Author("Fyodor", "Dostoyevsky");
        Book theIdiot       = new Book("The Idiot", "AAC234234");
        dostoyevsky.getBooks().add(theIdiot);
        theIdiot.getAuthors().add(dostoyevsky);
        theIdiot.setPublisher(publisher);
        publisher.getBooks().add(theIdiot);
        //Save in the repository
        authorRepository.save(dostoyevsky);
        bookRepository.save(theIdiot);
        publisherRepository.save(publisher);


        Author tolstoy      = new Author("Loe", "Tolstoy");
        Book warAndPeace    = new Book("War and Peace", "ABB566534");
        tolstoy.getBooks().add(warAndPeace);
        warAndPeace.getAuthors().add(tolstoy);
        warAndPeace.setPublisher(publisher);
        publisher.getBooks().add(warAndPeace);
        authorRepository.save(tolstoy);
        bookRepository.save(warAndPeace);
        publisherRepository.save(publisher);

        System.out.println("BootStrap started...");
        System.out.println("Total books in repository = "+bookRepository.count());
        System.out.println("Total authors in repository = "+authorRepository.count());
        System.out.println("Publisher book count is  "+publisher.getBooks().size());

    }
}
