package com.example.Alfayomi.dto;

import com.example.Alfayomi.entity.Role;
import lombok.Builder;
import org.springframework.lang.NonNull;

@Builder
public record UserDTO(
    String firstName,
    String lastName,
    String email,
    String city,
    String address,
    String phone,
    Role role
) {
}
