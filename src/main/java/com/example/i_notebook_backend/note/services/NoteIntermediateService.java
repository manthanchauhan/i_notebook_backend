package com.example.i_notebook_backend.note.services;

import com.example.i_notebook_backend.note.dtos.ListNotesResponseDto;
import com.example.i_notebook_backend.note.models.Note;
import com.example.i_notebook_backend.user.models.User;
import com.example.i_notebook_backend.user.services.UserIntermediateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteIntermediateService {
    public final NoteService noteService;

    public NoteIntermediateService(NoteService noteService) {
        this.noteService = noteService;
    }

    public ListNotesResponseDto getAllNotesOfRequestUser(){
        User user = UserIntermediateService.getRequestUser();
        List<Note> noteList = noteService.getAllNotes(user.getId());

        return ListNotesResponseDto.fromNoteList(noteList);
    }
}
