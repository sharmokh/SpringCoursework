package com.sharmokh.mongorecipeapp.converters;

import com.sharmokh.mongorecipeapp.commands.IngredientCommand;
import com.sharmokh.mongorecipeapp.model.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter = new UnitOfMeasureToUnitOfMeasureCommand();

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        return IngredientCommand.builder().id(ingredient.getId())
                                .recipeId(ingredient.getRecipe().getId())
                                .description(ingredient.getDescription())
                                .amount(ingredient.getAmount())
                                .uom(uomConverter.convert(ingredient.getUnitOfMeasure()))
                                .build();
    }
}
