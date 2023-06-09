package com.example.i_notebook_backend.note.controllers;

import com.example.i_notebook_backend.config.constants.RequestResponseConst;
import com.example.i_notebook_backend.note.dtos.CreateNoteRequestDto;
import com.example.i_notebook_backend.note.dtos.ListNotesResponseDto;
import com.example.i_notebook_backend.note.models.Note;
import com.example.i_notebook_backend.note.services.NoteIntermediateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {
    private final NoteIntermediateService noteIntermediateService;

    public NotesController(NoteIntermediateService noteIntermediateService) {
        this.noteIntermediateService = noteIntermediateService;
    }

    @GetMapping("")
    public ResponseEntity<ListNotesResponseDto> getAllNotes(){
        ListNotesResponseDto responseDto =  noteIntermediateService.getAllNotesOfRequestUser();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Note> createNote(@RequestBody @Valid CreateNoteRequestDto requestBody){
        Note note = noteIntermediateService.createNote(requestBody);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PatchMapping("/{noteId}")
    public ResponseEntity<Map<String, String>> updateNote(@RequestBody @Valid CreateNoteRequestDto requestDto,
                                                          @PathVariable Long noteId) {
        noteIntermediateService.updateNote(noteId, requestDto);
        return new ResponseEntity<>(RequestResponseConst.successResponseMap, HttpStatus.OK);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Map<String, String>> deleteNote(@PathVariable Long noteId){
        noteIntermediateService.deleteNote(noteId);
        return new ResponseEntity<>(RequestResponseConst.successResponseMap, HttpStatus.OK);
    }
}
