package com.notes.notesapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String name) {
        this.username = name;
    }
}
