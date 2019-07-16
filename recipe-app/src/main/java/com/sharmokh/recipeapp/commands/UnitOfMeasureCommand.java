package com.sharmokh.recipeapp.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UnitOfMeasureCommand {
    private Long id;
    private String description;

    @Builder
    public UnitOfMeasureCommand(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
