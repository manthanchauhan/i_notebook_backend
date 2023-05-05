package com.example.i_notebook_backend.user.services;

import com.example.i_notebook_backend.auth.services.AuthService;
import com.example.i_notebook_backend.user.dtos.request.CreateUserRequestDto;
import com.example.i_notebook_backend.user.dtos.response.CreateUserResponseDto;
import com.example.i_notebook_backend.user.dtos.response.UserProfileResponseDto;
import com.example.i_notebook_backend.user.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserIntermediateService {
    private final UserService userService;
    private final AuthService authService;

    public UserIntermediateService(UserService userService, AuthService authService){
        this.userService = userService;
        this.authService = authService;
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto requestDto){
        User user = userService.getUserByEmail(requestDto.getEmail());

        if (user == null){
            user = this.userService.createUser(requestDto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This email already exists");
        }

        String authToken = this.authService.generateAuthToken(user);
        return new CreateUserResponseDto(authToken);
    }

    public UserProfileResponseDto getProfile(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return UserProfileResponseDto.fromUser(user);
    }
}
