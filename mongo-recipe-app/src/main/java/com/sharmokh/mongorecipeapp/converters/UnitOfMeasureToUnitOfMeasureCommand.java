package com.sharmokh.mongorecipeapp.converters;

import com.sharmokh.mongorecipeapp.commands.UnitOfMeasureCommand;
import com.sharmokh.mongorecipeapp.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure == null) {
            return null;
        }
        return UnitOfMeasureCommand.builder().id(unitOfMeasure.getId())
                                   .description(unitOfMeasure.getDescription())
                                   .build();
    }
}
