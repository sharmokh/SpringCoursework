package com.sharmokh.recipeapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"recipe"})
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

    @Builder
    public Notes(Long id, Recipe recipe, String recipeNotes) {
        this.id = id;
        this.recipe = recipe;
        this.recipeNotes = recipeNotes;
    }
}
