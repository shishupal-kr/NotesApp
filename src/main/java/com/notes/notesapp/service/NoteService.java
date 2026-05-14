package com.notes.notesapp.service;

import com.notes.notesapp.dto.NoteRequestDto;
import com.notes.notesapp.dto.NoteResponseDto;
import com.notes.notesapp.entity.Note;
import com.notes.notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public NoteResponseDto createNote(NoteRequestDto noteRequestDto) {

        Note note = new Note();

        note.setTitle(noteRequestDto.getTitle());
        note.setContent(noteRequestDto.getContent());

        Note savedNote = noteRepository.save(note);

        NoteResponseDto responseDto = new NoteResponseDto();

        responseDto.setId(savedNote.getId());
        responseDto.setTitle(savedNote.getTitle());
        responseDto.setContent(savedNote.getContent());

        return responseDto;
    }

    public List<NoteResponseDto> getAllNotes(){

        List<Note> notes = noteRepository.findAll();

        List<NoteResponseDto> responseList = new ArrayList();
        for (Note note: notes){
            NoteResponseDto dto = new NoteResponseDto();

            dto.setId(note.getId());
            dto.setTitle(note.getTitle());
            dto.setContent(note.getContent());

            responseList.add(dto);
        }
        return responseList;
    }
}
