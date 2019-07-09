package com.sharmokh.recipeapp.repositories;

import com.sharmokh.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
