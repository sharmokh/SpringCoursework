package com.sharmokh.recipeapp.repositories;

import com.sharmokh.recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
