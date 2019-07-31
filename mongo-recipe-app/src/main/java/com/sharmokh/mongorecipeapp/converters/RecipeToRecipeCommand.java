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
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    public static final IngredientToIngredientCommand ingredientConverter = new IngredientToIngredientCommand();
    public static final NotesToNotesCommand notesConverter = new NotesToNotesCommand();
    public static final CategorytoCategoryCommand categoryConverter = new CategorytoCategoryCommand();

    @SuppressWarnings("Duplicates")
    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        Set<IngredientCommand> ingredients = new HashSet<>();
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredients.add(ingredientConverter.convert(ingredient));
        }

        Set<CategoryCommand> categories = new HashSet<>();
        for (Category category : recipe.getCategories()) {
            categories.add(categoryConverter.convert(category));
        }

        return RecipeCommand.builder().id(recipe.getId())
                            .description(recipe.getDescription())
                            .prepTime(recipe.getPrepTime())
                            .cookTime(recipe.getCookTime())
                            .servings(recipe.getServings())
                            .source(recipe.getSource())
                            .url(recipe.getUrl())
                            .image(recipe.getImage())
                            .directions(recipe.getDirections())
                            .ingredients(ingredients)
                            .difficulty(recipe.getDifficulty())
                            .notes(notesConverter.convert(recipe.getNotes()))
                            .categories(categories)
                            .build();
    }
}
