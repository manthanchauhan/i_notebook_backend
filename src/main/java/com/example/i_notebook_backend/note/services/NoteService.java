package com.example.i_notebook_backend.note.services;

import com.example.i_notebook_backend.note.models.Note;
import com.example.i_notebook_backend.note.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    public final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    List<Note> getAllNotes(Long userId){
        return noteRepository.findAll(NoteRepository.hasUserId(userId));
    }
}
