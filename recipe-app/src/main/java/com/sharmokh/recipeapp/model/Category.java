package com.sharmokh.recipeapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    // Auto-generated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Each Category has many Recipes
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    @Builder
    public Category(Long id, String name, Set<Recipe> recipes) {
        this.id = id;
        this.name = name;
        this.recipes = recipes;
    }
}
