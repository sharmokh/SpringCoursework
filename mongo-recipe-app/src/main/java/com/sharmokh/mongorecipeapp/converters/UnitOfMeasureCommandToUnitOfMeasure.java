package com.sharmokh.mongorecipeapp.converters;

import com.sharmokh.mongorecipeapp.commands.UnitOfMeasureCommand;
import com.sharmokh.mongorecipeapp.model.UnitOfMeasure;
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
