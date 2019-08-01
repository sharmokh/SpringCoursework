package com.sharmokh.mongorecipeapp.services;

import com.sharmokh.mongorecipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteByRecipeIdAndIngredientId(String recipeId, String ingredientId);
}
