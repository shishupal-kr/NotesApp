package com.notes.notesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

}
