package com.sharmokh.mongorecipeapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"recipe"})
public class Ingredient {

    private String id;
    private String description;
    private BigDecimal amount;
    private Recipe recipe;
    private UnitOfMeasure unitOfMeasure;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    @Builder
    public Ingredient(String id, String description, BigDecimal amount, Recipe recipe, UnitOfMeasure unitOfMeasure) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.unitOfMeasure = unitOfMeasure;
    }
}
