package com.notes.notesapp.controller;

import com.notes.notesapp.dto.NoteResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.notes.notesapp.service.NoteService;

import java.util.List;

import com.notes.notesapp.dto.NoteRequestDto;

@RestController
public class NoteController {

    private final NoteService noteService;  // using service layer

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public NoteResponseDto createNote(
            @Valid @RequestBody NoteRequestDto noteRequestDto // json to java object and store in NoteDto (deserialization)
    ) {
        //logic in service layer
        return noteService.createNote(noteRequestDto);
    }

    @GetMapping("/notes")
    public List<NoteResponseDto> getAllNotes(){
        return noteService.getAllNotes();
    }

    @PutMapping("/notes/{id}")
    public NoteResponseDto updateNote(
        @PathVariable Long id,
                @Valid @RequestBody NoteRequestDto noteRequestDto
    ){
        return noteService.updateNote(id, noteRequestDto);
    }

}
