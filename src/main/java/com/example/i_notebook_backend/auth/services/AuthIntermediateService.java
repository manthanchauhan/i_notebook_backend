package com.example.i_notebook_backend.auth.services;

import com.example.i_notebook_backend.auth.dto.UserLoginRequestDto;
import com.example.i_notebook_backend.user.dtos.response.CreateUserResponseDto;
import com.example.i_notebook_backend.user.models.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthIntermediateService {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    public AuthIntermediateService(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    public CreateUserResponseDto login(UserLoginRequestDto requestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getEmail(), requestDto.getPassword()
                )
        );

        User user = (User) authentication.getPrincipal();
        String authToken = this.authService.generateAuthToken(user);

        return new CreateUserResponseDto(authToken);
    }
}
