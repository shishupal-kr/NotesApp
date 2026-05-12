package com.notes.notesapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    private Long getId(){
        return id;
    }

    private String getTitle(){
        return title;
    }
    private void setTitle(String title){
        this.title = title;
    }

    private String getContent(){
        return content;
    }
    private void setContent(String content){
        this.content = content;
    }

}
