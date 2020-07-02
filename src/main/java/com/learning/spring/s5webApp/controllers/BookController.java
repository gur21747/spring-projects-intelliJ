package com.learning.spring.s5webApp.controllers;

import com.learning.spring.s5webApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository; // We are injecting an instance of the BookRepository (Spring DI)

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") /*At runtime when spring gets request for this URL /books then it will
                                execute this getBooks method. It provides the method a model object
                                and we have added an attribute to the model called books. This model
                                going to return back to view layer with a list of books.
                                */
    public String getBooks(Model model){

        model.addAttribute("books",bookRepository.findAll());
        return "books/list";
    }
}
