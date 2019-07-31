package com.sharmokh.mongorecipeapp.converters;

import com.sharmokh.mongorecipeapp.commands.NotesCommand;
import com.sharmokh.mongorecipeapp.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes  implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand notesCommand) {
        if (notesCommand == null) {
            return null;
        }
        return Notes.builder().id(notesCommand.getId())
                    .recipeNotes(notesCommand.getRecipeNotes())
                    .build();
    }
}
