package com.sharmokh.mongorecipeapp.converters;

import com.sharmokh.mongorecipeapp.commands.CategoryCommand;
import com.sharmokh.mongorecipeapp.commands.IngredientCommand;
import com.sharmokh.mongorecipeapp.commands.RecipeCommand;
import com.sharmokh.mongorecipeapp.model.Category;
import com.sharmokh.mongorecipeapp.model.Ingredient;
import com.sharmokh.mongorecipeapp.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    public static final IngredientCommandToIngredient ingredientConverter = new IngredientCommandToIngredient();
    public static final NotesCommandToNotes notesConverter = new NotesCommandToNotes();
    public static final CategoryCommandToCategory categoryConverter = new CategoryCommandToCategory();

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if (recipeCommand == null) {
            return null;
        }

        Set<Ingredient> ingredients = new HashSet<>();
        for (IngredientCommand ingredient : recipeCommand.getIngredients()) {
            ingredients.add(ingredientConverter.convert(ingredient));
        }

        Set<Category> categories = new HashSet<>();
        for (CategoryCommand category : recipeCommand.getCategories()) {
            categories.add(categoryConverter.convert(category));
        }

        return Recipe.builder().id(recipeCommand.getId())
                     .description(recipeCommand.getDescription())
                     .prepTime(recipeCommand.getPrepTime())
                     .cookTime(recipeCommand.getCookTime())
                     .servings(recipeCommand.getServings())
                     .source(recipeCommand.getSource())
                     .url(recipeCommand.getUrl())
                     .difficulty(recipeCommand.getDifficulty())
                     .ingredients(ingredients)
                     .directions(recipeCommand.getDirections())
                     // .images(recipeCommand.getImage())
                     .notes(notesConverter.convert(recipeCommand.getNotes()))
                     .categories(categories)
                     .build();
    }
}
