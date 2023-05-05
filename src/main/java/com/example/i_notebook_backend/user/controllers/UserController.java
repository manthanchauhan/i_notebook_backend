package com.example.i_notebook_backend.user.controllers;

import com.example.i_notebook_backend.user.dtos.request.CreateUserRequestDto;
import com.example.i_notebook_backend.user.dtos.response.CreateUserResponseDto;
import com.example.i_notebook_backend.user.dtos.response.UserProfileResponseDto;
import com.example.i_notebook_backend.user.services.UserIntermediateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserIntermediateService userIntermediateService;

    public UserController(UserIntermediateService userIntermediateService) {
        this.userIntermediateService = userIntermediateService;
    }

    @PostMapping("")
    public ResponseEntity<CreateUserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto requestDto){
        CreateUserResponseDto responseDto = this.userIntermediateService.createUser(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponseDto> getProfile(){
        UserProfileResponseDto responseDto = this.userIntermediateService.getProfile();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
