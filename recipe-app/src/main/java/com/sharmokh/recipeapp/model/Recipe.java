package com.sharmokh.recipeapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Recipe {

    // Auto-generated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    // Changed default value from ordinal to string in case of future changes in Difficulty
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    // Set of Ingredients mapped by Recipe and cascade to delete ingredients if recipe is deleted
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    // Large Object Storage
    @Lob
    private String directions;
    @Lob
    private Byte[] image;

    // Cascade to delete notes if recipe is deleted
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // Each Recipe can be a part of multiple Categories
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "recipe_category",
               joinColumns = @JoinColumn(name = "recipe_id"),
               inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    @Builder
    public Recipe(Long id, String description, Integer prepTime, Integer cookTime, Integer servings, String source,
                  String url, Difficulty difficulty, Set<Ingredient> ingredients, String directions, Byte[] image,
                  Notes notes, Set<Category> categories) {
        this.id = id;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.source = source;
        this.url = url;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.directions = directions;
        this.image = image;
        this.notes = notes;
        this.categories = categories;
    }
}
