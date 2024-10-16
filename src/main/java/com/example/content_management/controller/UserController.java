package com.example.content_management.controller;

import com.example.content_management.dto.UserDTO;
import com.example.content_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:63342")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserDTO saveUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO user) {
        UserDTO loggedInUser = userService.login(user);
        return ResponseEntity.ok(loggedInUser);
    }
}
