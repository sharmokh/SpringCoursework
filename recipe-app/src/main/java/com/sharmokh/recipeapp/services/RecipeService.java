package com.sharmokh.recipeapp.services;

import com.sharmokh.recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
