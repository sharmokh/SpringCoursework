package com.sharmokh.mongorecipeapp.services;

import com.sharmokh.mongorecipeapp.commands.RecipeCommand;
import com.sharmokh.mongorecipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Recipe findById(String id);
    Set<Recipe> getRecipes();
    RecipeCommand findCommandById(String id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    void deleteById(String id);
}
