package com.notes.notesapp.controller;

import com.notes.notesapp.entity.Note;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notes.notesapp.service.NoteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.notes.notesapp.dto.NoteRequestDto;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class NoteController {

    private final NoteService noteService;  // using service layer
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/hello")
    public Map<String, String> gethello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "hello how are you !");
        return response;
    }

    @PostMapping("/hello")
    public Map<String, String> posthello() {
        Map<String, String> response = new HashMap<>();

        response.put("message", "This is Post Api");
        return response;
    }

    @PostMapping("/notes")
    public Map<String, String> createNote(@Valid @RequestBody NoteRequestDto noteDto) { // json to java object and store in NoteDto (deserialization)
        //logic in service layer
        return noteService.createNote(noteDto);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

}
