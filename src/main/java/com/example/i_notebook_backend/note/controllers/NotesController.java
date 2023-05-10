package com.example.i_notebook_backend.note.controllers;

import com.example.i_notebook_backend.note.dtos.ListNotesResponseDto;
import com.example.i_notebook_backend.note.services.NoteIntermediateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
