package com.notes.notesapp.service;

import com.notes.notesapp.dto.NoteRequestDto;
import com.notes.notesapp.dto.NoteResponseDto;
import com.notes.notesapp.entity.Note;
import com.notes.notesapp.entity.User;
import com.notes.notesapp.exception.ResourceNotFoundException;
import com.notes.notesapp.repository.NoteRepository;
import com.notes.notesapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    //Create Note Logic
    public NoteResponseDto createNote(NoteRequestDto noteRequestDto) {

        User user =  findUserById(noteRequestDto.getUserId());

        Note note = new Note();

        note.setUser(user);
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

        Note note = findNoteById(id);

        note.setTitle(noteRequestDto.getTitle());
        note.setContent(noteRequestDto.getContent());

        note.setUpdatedAt(LocalDateTime.now());

        Note updatedNote = noteRepository.save(note);

        return mapToResponseDto(updatedNote);
    }

    //Delete Note Logic
    public String deleteNote(Long id) {

        findNoteById(id);

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

    // Reusable Maps Entity to Response DTO
    private NoteResponseDto mapToResponseDto(Note note) {

        NoteResponseDto dto = new NoteResponseDto();

        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setCreatedAt(note.getCreatedAt());
        dto.setUpdatedAt(note.getUpdatedAt());

        return dto;
    }

    // Reusable Finds Note by ID or throws exception
    private Note findNoteById(Long id) {

        return noteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Note not found"));
    }

    private User findUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"
                        ));
    }
}
