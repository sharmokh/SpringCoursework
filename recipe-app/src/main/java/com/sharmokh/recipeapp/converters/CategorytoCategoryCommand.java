package com.sharmokh.recipeapp.converters;

import com.sharmokh.recipeapp.commands.CategoryCommand;
import com.sharmokh.recipeapp.model.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategorytoCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if (source == null) {
            return null;
        }
        return CategoryCommand.builder().id(source.getId()).name(source.getName()).build();
    }

}
