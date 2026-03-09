package com.swiftbites.api.controller;

import com.swiftbites.api.entity.UserEntity;
import com.swiftbites.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity user){
        return userRepository
                .findByEmailAndPassword(user.getEmail(), user.getPassword());
    }
}