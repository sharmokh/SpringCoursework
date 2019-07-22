package com.sharmokh.recipeapp.converters;

import com.sharmokh.recipeapp.commands.IngredientCommand;
import com.sharmokh.recipeapp.model.Ingredient;
import com.sharmokh.recipeapp.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private static final UnitOfMeasureCommandToUnitOfMeasure uomConverter = new UnitOfMeasureCommandToUnitOfMeasure();

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }
        Recipe recipe = new Recipe();
        if(source.getRecipeId() != null){
            recipe.setId(source.getRecipeId());
        }
        return Ingredient.builder().id(source.getId())
                         .recipe(recipe)
                         .amount(source.getAmount())
                         .description(source.getDescription())
                         .unitOfMeasure(uomConverter.convert(source.getUom()))
                         .build();
    }
}
