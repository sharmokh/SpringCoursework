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
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasureCommand;

    @Builder
    public IngredientCommand(Long id, String description, BigDecimal amount,
                             UnitOfMeasureCommand unitOfMeasureCommand) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.unitOfMeasureCommand = unitOfMeasureCommand;
    }
}
