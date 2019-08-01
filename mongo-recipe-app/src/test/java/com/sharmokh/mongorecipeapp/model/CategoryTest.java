package com.sharmokh.mongorecipeapp.model;

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
        category.setId("3");
        assertEquals("3", category.getId());
    }

    @Test
    public void getName() {
    }

    @Test
    public void getRecipes() {
    }
}