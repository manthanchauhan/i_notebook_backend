package com.example.i_notebook_backend.config.jwtAuth;

import com.example.i_notebook_backend.config.errorHandling.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    // https://www.youtube.com/watch?v=P_29bHsVjjg

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, authException.getMessage());
        String msg = new ObjectMapper().writeValueAsString(apiError);

        response.setContentType("application/json");
        response.getOutputStream().print(msg);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
