package com.example.i_notebook_backend.note.dtos;

import com.example.i_notebook_backend.note.models.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListNotesResponseDto {
    private List<Note> noteList;
    private int count;

    public static ListNotesResponseDto fromNoteList(List<Note> noteList){
        return new ListNotesResponseDto(noteList, noteList.size());
    }
}
