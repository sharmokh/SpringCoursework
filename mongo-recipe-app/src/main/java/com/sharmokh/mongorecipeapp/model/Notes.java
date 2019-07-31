package com.sharmokh.mongorecipeapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"recipe"})
public class Notes {

    private Long id;
    private Recipe recipe;
    private String recipeNotes;

    @Builder
    public Notes(Long id, Recipe recipe, String recipeNotes) {
        this.id = id;
        this.recipe = recipe;
        this.recipeNotes = recipeNotes;
    }
}
