package com.learning.spring.s5webApp.repositories;

import com.learning.spring.s5webApp.model.Book;
import com.learning.spring.s5webApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
