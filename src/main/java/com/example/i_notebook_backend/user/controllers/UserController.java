package com.example.i_notebook_backend.user.controllers;

import com.example.i_notebook_backend.user.dtos.request.CreateUserRequestDto;
import com.example.i_notebook_backend.user.services.UserIntermediateService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/users")
//@Validated
public class UserController {
    private final UserIntermediateService userIntermediateService;

    public UserController(UserIntermediateService userIntermediateService) {
        this.userIntermediateService = userIntermediateService;
    }

    @PostMapping("")
    public Map<String, String> createUser(@Valid @RequestBody CreateUserRequestDto requestDto){
        this.userIntermediateService.createUser(requestDto);
        return Collections.singletonMap("message", "User created");
    }
}
