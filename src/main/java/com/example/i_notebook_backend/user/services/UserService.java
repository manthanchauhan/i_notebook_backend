package com.example.i_notebook_backend.user.services;

import com.example.i_notebook_backend.user.dtos.request.CreateUserRequestDto;
import com.example.i_notebook_backend.user.models.User;
import com.example.i_notebook_backend.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    // https://stackoverflow.com/a/39892204
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(CreateUserRequestDto requestDto){
        User user = new User(
                requestDto.getFirstName(),
                requestDto.getLastName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        userRepository.save(user);
    }
}
