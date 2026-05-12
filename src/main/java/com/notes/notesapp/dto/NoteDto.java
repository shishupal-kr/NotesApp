package com.notes.notesapp.dto;

//data transfer object (dto)

public class NoteDto {

    public String title;

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
