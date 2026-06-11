package com.notes.notesapp.controller;

import com.notes.notesapp.dto.UserRequestDto;
import com.notes.notesapp.dto.UserResponseDto;
import com.notes.notesapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto createUser(
            @Valid
            @RequestBody
            UserRequestDto requestDto
    ){
        return userService.createUser(requestDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(
            @PathVariable Long id
    ) {

        return userService.getUserById(id);
    }
}
