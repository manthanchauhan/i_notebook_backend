package com.example.i_notebook_backend.user.controllers;

import com.example.i_notebook_backend.user.dtos.request.CreateUserRequestDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
//@Validated
public class UserController {
    @PostMapping("")
    public void createUser(@Valid @RequestBody CreateUserRequestDto requestDto){
        System.out.println(requestDto);
    }
}
