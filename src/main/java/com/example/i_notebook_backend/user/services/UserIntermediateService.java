package com.example.i_notebook_backend.user.services;

import com.example.i_notebook_backend.user.dtos.request.CreateUserRequestDto;
import com.example.i_notebook_backend.user.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserIntermediateService {
    private final UserService userService;

    public UserIntermediateService(UserService userService){
        this.userService = userService;
    }

    public void createUser(CreateUserRequestDto requestDto){
        User user = userService.getUserByEmail(requestDto.getEmail());

        if (user == null){
            this.userService.createUser(requestDto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This email already exists");
        }
    }
}
