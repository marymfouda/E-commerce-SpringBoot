package com.example.Alfayomi.dto;

import lombok.Builder;

@Builder
public record CategoriesDTO(
        String type ,
        Double price
 ) {
}
