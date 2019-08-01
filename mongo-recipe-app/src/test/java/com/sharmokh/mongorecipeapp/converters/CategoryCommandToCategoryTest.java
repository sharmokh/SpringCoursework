package com.sharmokh.mongorecipeapp.converters;

import com.sharmokh.mongorecipeapp.commands.CategoryCommand;
import com.sharmokh.mongorecipeapp.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "description";
    public static final String ID = "1";
    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }



    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setName(DESCRIPTION);
        categoryCommand.setId(ID);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assertEquals(ID, category.getId());
        assertEquals(DESCRIPTION, category.getName());
    }
}