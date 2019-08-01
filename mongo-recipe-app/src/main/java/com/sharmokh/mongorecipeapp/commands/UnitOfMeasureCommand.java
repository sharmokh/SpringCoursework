package com.sharmokh.mongorecipeapp.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private String id;
    private String description;

    @Builder
    public UnitOfMeasureCommand(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
