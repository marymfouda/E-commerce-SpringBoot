package com.example.Alfayomi.dto;

import lombok.Builder;

@Builder
public record OrderItemDTO(
         int quantity,
         Double price,
         Double totalPrice
) {
}
