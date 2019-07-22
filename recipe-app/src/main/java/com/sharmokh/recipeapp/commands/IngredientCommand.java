package com.sharmokh.recipeapp.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class IngredientCommand {
    private Long id;
    private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;

    @Builder
    public IngredientCommand(Long id, Long recipeId, String description, BigDecimal amount, UnitOfMeasureCommand uom) {
        this.id = id;
        this.recipeId = recipeId;
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }
}
