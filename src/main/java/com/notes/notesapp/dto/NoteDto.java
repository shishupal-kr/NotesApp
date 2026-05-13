package com.notes.notesapp.dto;

//data transfer object (dto)

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NoteDto {

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 3, max = 50, message = "Title must be btwn 3-50 characters" )
    public String title;

    @NotBlank(message = "Content cannot be empty")
    @Size(min = 1, message = "Must be 1 character")
    public String content;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
