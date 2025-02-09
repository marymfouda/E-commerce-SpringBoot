package com.example.Alfayomi.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CartDTO(
        Long quantity,
        LocalDate created_at) {
}
