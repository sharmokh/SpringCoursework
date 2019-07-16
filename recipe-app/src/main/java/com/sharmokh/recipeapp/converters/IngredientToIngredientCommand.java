package com.sharmokh.recipeapp.converters;

import com.sharmokh.recipeapp.commands.IngredientCommand;
import com.sharmokh.recipeapp.model.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private static final UnitOfMeasureToUnitOfMeasureCommand uomConverter = new UnitOfMeasureToUnitOfMeasureCommand();

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        return IngredientCommand.builder().id(ingredient.getId())
                                .description(ingredient.getDescription())
                                .amount(ingredient.getAmount())
                                .unitOfMeasureCommand(uomConverter.convert(ingredient.getUnitOfMeasure()))
                                .build();
    }
}
