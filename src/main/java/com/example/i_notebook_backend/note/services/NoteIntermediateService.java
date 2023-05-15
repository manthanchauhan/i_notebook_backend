package com.example.i_notebook_backend.note.services;

import com.example.i_notebook_backend.note.dtos.CreateNoteRequestDto;
import com.example.i_notebook_backend.note.dtos.ListNotesResponseDto;
import com.example.i_notebook_backend.note.models.Note;
import com.example.i_notebook_backend.user.models.User;
import com.example.i_notebook_backend.user.services.UserIntermediateService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void createNote(CreateNoteRequestDto requestDto){
        User user = UserIntermediateService.getRequestUser();

        Note note = new Note(requestDto.getTitle(), requestDto.getDescription(), user.getId());
        noteService.createNote(note);
    }

    public void updateNote(Long noteId, CreateNoteRequestDto requestDto){
        Note note = noteService.getNoteById(noteId);

        if (note == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }

        User requestUser = UserIntermediateService.getRequestUser();

        if (!requestUser.getId().equals(note.getUserId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }

        note.setTitle(requestDto.getTitle());
        note.setDescription(requestDto.getDescription());
        noteService.updateNote(note);
    }

    public void deleteNote(Long noteId){
        noteService.deleteNote(noteId);
    }
}
