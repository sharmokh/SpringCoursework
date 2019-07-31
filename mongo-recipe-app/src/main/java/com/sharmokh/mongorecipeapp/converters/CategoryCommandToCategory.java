package com.sharmokh.mongorecipeapp.converters;

import com.sharmokh.mongorecipeapp.commands.CategoryCommand;
import com.sharmokh.mongorecipeapp.model.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }
        return Category.builder().id(source.getId()).name(source.getName()).build();
    }

}
