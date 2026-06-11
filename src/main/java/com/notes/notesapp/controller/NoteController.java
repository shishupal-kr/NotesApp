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

    //HTTPS handler for user interaction

    @PostMapping("/notes")
    public NoteResponseDto createNote(
            @Valid @RequestBody NoteRequestDto noteRequestDto
    ) {
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

    @DeleteMapping("notes/{id}")
    public String deleteNote(@PathVariable Long id){

        return noteService.deleteNote(id);
    }

    @GetMapping("/notes/search")
    public List<NoteResponseDto> searchNotesByTitle(
            @RequestParam String title
    ) {
        return noteService.searchNotesByTitle(title);
    }

    @GetMapping("/users/{userId}/notes")
    public List<NoteResponseDto> getNotesByUserId(
            @PathVariable Long userId
    ) {
        return noteService.getNotesByUserId(userId);
    }
}
