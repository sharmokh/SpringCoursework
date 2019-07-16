package com.sharmokh.recipeapp.converters;

import com.sharmokh.recipeapp.commands.NotesCommand;
import com.sharmokh.recipeapp.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {
        if (notes == null) {
            return null;
        }
        return NotesCommand.builder().id(notes.getId())
                           .recipeNotes(notes.getRecipeNotes())
                           .build();
    }
}
