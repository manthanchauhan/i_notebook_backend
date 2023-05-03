package com.example.i_notebook_backend.auth.services;

import com.example.i_notebook_backend.auth.utils.JwtTokenUtil;
import com.example.i_notebook_backend.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthService(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public String generateAuthToken(User user){
        return jwtTokenUtil.generateToken(user);
    }
}
