package com.sharmokh.mongorecipeapp.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private String id;
    private String recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;

    @Builder
    public IngredientCommand(String id, String recipeId, String description,
                             BigDecimal amount, UnitOfMeasureCommand uom) {
        this.id = id;
        this.recipeId = recipeId;
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }
}
