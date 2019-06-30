package com.sharmokh.spring5framework.repositories;

import com.sharmokh.spring5framework.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
