package com.notes.notesapp.service;

import com.notes.notesapp.dto.NoteDto;
import com.notes.notesapp.entity.Note;
import com.notes.notesapp.repository.NoteRepository;
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

        Note note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        Note savedNote = noteRepository.save(note);

        Map<String, String> response = new HashMap<>();

        response.put("id", savedNote.getId().toString());
        response.put("title", savedNote.getTitle());
        response.put("content", savedNote.getContent());

        return response;

    }
}
