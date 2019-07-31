package com.sharmokh.mongorecipeapp.repositories;

import com.sharmokh.mongorecipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByName(String name);

}
