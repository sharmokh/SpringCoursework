package com.sharmokh.mongorecipeapp.repositories;

import com.sharmokh.mongorecipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
