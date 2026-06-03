package com.notes.notesapp.service;

import com.notes.notesapp.dto.UserRequestDto;
import com.notes.notesapp.dto.UserResponseDto;
import com.notes.notesapp.entity.User;
import com.notes.notesapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(
            UserRequestDto requestDto
    ) {

        User user = new User();

        user.setUsername(requestDto.getUsername());

        User savedUser = userRepository.save(user);

        UserResponseDto responseDto =
                new UserResponseDto();

        responseDto.setId(savedUser.getId());
        responseDto.setUsername(savedUser.getUsername());

        return responseDto;
    }
}