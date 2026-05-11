package com.notes.notesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @GetMapping("/hello")
    public Map<String, String> gethello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "hello how are you !");
        return response;
    }

}
