package com.example.content_management.service.impl;

import com.example.content_management.dto.UserDTO;
import com.example.content_management.entity.UserEntity;
import com.example.content_management.repo.UserDAO;
import com.example.content_management.service.UserService;
import com.example.content_management.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserDAO userRepo;
    private final Mapping mapping;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO save(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password before saving
        userRepo.save(mapping.toUserEntity(user));
        return user;
    }

    @Override
    public UserDTO login(UserDTO user) {
        UserEntity foundUser = userRepo.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return mapping.toUserDTO(foundUser); // Return user DTO upon successful login
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @Override
    public Object userDetailService() {
        return null;
    }
}
