package com.sharmokh.mongorecipeapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"recipes"})
public class Category {

    private String id;
    private String name;
    private Set<Recipe> recipes;

    @Builder
    public Category(String id, String name, Set<Recipe> recipes) {
        this.id = id;
        this.name = name;
        this.recipes = recipes;
    }
}
