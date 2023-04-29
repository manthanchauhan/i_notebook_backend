package com.example.i_notebook_backend.user.services;

import com.example.i_notebook_backend.user.dtos.request.CreateUserRequestDto;
import org.springframework.stereotype.Service;

@Service
public class UserIntermediateService {
    private final UserService userService;

    public UserIntermediateService(UserService userService){
        this.userService = userService;
    }

    public void createUser(CreateUserRequestDto requestDto){
        this.userService.createUser(requestDto);
    }
}
