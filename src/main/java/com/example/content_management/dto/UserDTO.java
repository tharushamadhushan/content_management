package com.example.content_management.dto;

import com.example.content_management.entity.num.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
