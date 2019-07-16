package com.sharmokh.recipeapp.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryCommand {
    private Long id;
    private String name;

    @Builder
    public CategoryCommand(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
