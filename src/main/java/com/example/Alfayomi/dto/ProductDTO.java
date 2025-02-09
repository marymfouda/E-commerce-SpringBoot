package com.example.Alfayomi.dto;

import lombok.Builder;

@Builder
public record ProductDTO(
         String name ,
         String description,
         Double salary,
         Double rate,
         Boolean stock
) {
}
