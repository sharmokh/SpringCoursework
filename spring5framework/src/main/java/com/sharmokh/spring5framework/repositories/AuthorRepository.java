package com.sharmokh.spring5framework.repositories;

import com.sharmokh.spring5framework.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
