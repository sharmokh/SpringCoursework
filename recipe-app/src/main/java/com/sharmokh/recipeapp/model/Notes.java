package com.sharmokh.recipeapp.model;

import javax.persistence.*;

@Entity
public class Notes {

    // Auto-generated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    // Large Object Storage
    @Lob
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
