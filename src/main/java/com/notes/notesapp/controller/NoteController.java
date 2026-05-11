package com.notes.notesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @GetMapping("/hello")
    public String hello() {
        return "hello how are you !";
    }

}
