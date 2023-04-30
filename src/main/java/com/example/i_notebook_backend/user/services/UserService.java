package com.example.i_notebook_backend.user.services;

import com.example.i_notebook_backend.user.dtos.request.CreateUserRequestDto;
import com.example.i_notebook_backend.user.models.User;
import com.example.i_notebook_backend.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    // https://stackoverflow.com/a/39892204
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void createUser(CreateUserRequestDto requestDto){
        String encodedPassword = this.passwordEncoder.encode(requestDto.getPassword());

        User user = new User(
                requestDto.getFirstName(),
                requestDto.getLastName(),
                requestDto.getEmail(),
                encodedPassword
        );
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUserByEmail(String email){
        Optional<User> optionalUser = userRepository.findOne(UserRepository.hasEmail(email));
        return optionalUser.orElse(null);
    }
}
