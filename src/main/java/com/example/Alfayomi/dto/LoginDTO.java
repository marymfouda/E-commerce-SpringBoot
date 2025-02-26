package com.example.Alfayomi.dto;

import lombok.Builder;

@Builder
public record LoginDTO(
        String email ,
        String password
) {
}
