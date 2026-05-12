package com.notes.notesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.notes.notesapp.dto.NoteDto;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class NoteController {

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
    public Map<String, String> createNote(@RequestBody NoteDto NoteDto) { // json to java object and store in NoteDto (deserialization)

        Map<String, String> response = new HashMap<>();

        response.put("title", NoteDto.getTitle());
        response.put("content", NoteDto.getContent());

        return response;
    }

}
