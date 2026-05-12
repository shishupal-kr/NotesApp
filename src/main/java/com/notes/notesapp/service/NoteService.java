package com.notes.notesapp.service;

import com.notes.notesapp.dto.NoteDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Map<String, String> createNote(NoteDto noteDto) {

        Map<String, String> response = new HashMap<>();

        response.put("title", noteDto.getTitle());
        response.put("content", noteDto.getContent());

        return response;

    }
}
