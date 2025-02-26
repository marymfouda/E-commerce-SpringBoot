package com.example.Alfayomi.dto;

import com.example.Alfayomi.entity.Role;
import lombok.Builder;

@Builder
public record RegisterDTO(
        String firstName ,
        String lastName ,
        String email ,
        String password ,
        String city ,
        String phone ,
        Role role
) {
}
