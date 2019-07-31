package com.sharmokh.mongorecipeapp.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String name;

    @Builder
    public CategoryCommand(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
