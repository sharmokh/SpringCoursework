package com.sharmokh.recipeapp.converters;

import com.sharmokh.recipeapp.commands.UnitOfMeasureCommand;
import com.sharmokh.recipeapp.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        if (unitOfMeasureCommand == null) {
            return null;
        }
        return UnitOfMeasure.builder().id(unitOfMeasureCommand.getId())
                            .description(unitOfMeasureCommand.getDescription())
                            .build();
    }
}
