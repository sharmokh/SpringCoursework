package com.sharmokh.recipeapp.services;

import com.sharmokh.recipeapp.commands.RecipeCommand;
import com.sharmokh.recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Recipe findById(Long id);
    Set<Recipe> getRecipes();
    RecipeCommand findCommandById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    void deleteById(Long id);
}
