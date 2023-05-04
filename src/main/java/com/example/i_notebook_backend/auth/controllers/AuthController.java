package com.example.i_notebook_backend.auth.controllers;

import com.example.i_notebook_backend.auth.dto.UserLoginRequestDto;
import com.example.i_notebook_backend.auth.services.AuthIntermediateService;
import com.example.i_notebook_backend.user.dtos.response.CreateUserResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthIntermediateService authIntermediateService;

    public AuthController(AuthIntermediateService authIntermediateService) {
        this.authIntermediateService = authIntermediateService;
    }

    @PostMapping("/login")
    public CreateUserResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto){
        return this.authIntermediateService.login(requestDto);
    }
}
