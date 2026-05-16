package com.notes.notesapp.service;

import com.notes.notesapp.dto.NoteRequestDto;
import com.notes.notesapp.dto.NoteResponseDto;
import com.notes.notesapp.entity.Note;
import com.notes.notesapp.exception.ResourceNotFoundException;
import com.notes.notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    //Create Note Logic
    public NoteResponseDto createNote(NoteRequestDto noteRequestDto) {

        Note note = new Note();

        note.setTitle(noteRequestDto.getTitle());
        note.setContent(noteRequestDto.getContent());

        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());

        Note savedNote = noteRepository.save(note);

        return mapToResponseDto(savedNote);
    }

    //View Note Logic
    public List<NoteResponseDto> getAllNotes() {

        List<Note> notes = noteRepository.findAll();

        List<NoteResponseDto> responseList = new ArrayList();

        for (Note note : notes) {
            responseList.add(mapToResponseDto(note));
        }
        return responseList;
    }

    //Update Note Logic
    public NoteResponseDto updateNote(Long id, NoteRequestDto noteRequestDto) {

        Optional<Note> optionalNote = noteRepository.findById(id);

        if (optionalNote.isEmpty()) {
            throw new ResourceNotFoundException("Note not found");
        }

        Note note = optionalNote.get();
        note.setTitle(noteRequestDto.getTitle());
        note.setContent(noteRequestDto.getContent());

        note.setUpdatedAt(LocalDateTime.now());

        Note updatedNote = noteRepository.save(note);

        return mapToResponseDto(updatedNote);
    }

    //Delete Note Logic
    public String deleteNote(Long id) {

        Optional<Note> optionalNote = noteRepository.findById(id);

        if (optionalNote.isEmpty()) {
            throw new ResourceNotFoundException("Note not found");
        }
        noteRepository.deleteById(id);

        return " Note deleted Successfully !";
    }

    //Search Note by Title Logic
    public List<NoteResponseDto> searchNotesByTitle(String title) {

        List<Note> notes = noteRepository.findByTitleContainingIgnoreCase(title);

        List<NoteResponseDto> responseList = new ArrayList<>();

        for (Note note : notes) {

            responseList.add(mapToResponseDto(note));
        }
        return responseList;
    }

    //Reusable helper Logic for Logic
    private NoteResponseDto mapToResponseDto(Note note) {

        NoteResponseDto dto = new NoteResponseDto();

        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setCreatedAt(note.getCreatedAt());
        dto.setUpdatedAt(note.getUpdatedAt());

        return dto;
    }
}
