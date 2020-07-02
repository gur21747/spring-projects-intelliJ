package com.learning.spring.s5webApp.repositories;

import com.learning.spring.s5webApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
