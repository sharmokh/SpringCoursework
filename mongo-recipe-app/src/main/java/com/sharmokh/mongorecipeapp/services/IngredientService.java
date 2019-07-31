package com.sharmokh.mongorecipeapp.services;

import com.sharmokh.mongorecipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
