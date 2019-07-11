package com.sharmokh.recipeapp.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 3L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getName() {
    }

    @Test
    public void getRecipes() {
    }
}