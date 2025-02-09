package com.example.Alfayomi.dto;

import lombok.Builder;

@Builder
public record OrderDTO(
         Double subtotal,
         Double discount,
         Double deliveryFee,
         Double total,
         String promoCode
) {
}
