package com.sharmokh.recipeapp.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NotesCommand {
    private Long id;
    private String recipeNotes;

    @Builder
    public NotesCommand(Long id, String recipeNotes) {
        this.id = id;
        this.recipeNotes = recipeNotes;
    }
}
