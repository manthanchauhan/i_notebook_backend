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

    public List<Note> getAllNotes(Long userId){
        return noteRepository.findAll(NoteRepository.hasUserId(userId));
    }

    public void createNote(Note note){
        noteRepository.save(note);
    }

    public Note getNoteById(Long noteId){
        return noteRepository.findById(noteId).orElse(null);
    }

    public void updateNote(Note note){
        noteRepository.save(note);
    }
}
