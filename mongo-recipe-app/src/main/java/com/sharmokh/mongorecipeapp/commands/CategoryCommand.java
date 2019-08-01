package com.sharmokh.mongorecipeapp.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
    private String id;
    private String name;

    @Builder
    public CategoryCommand(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
