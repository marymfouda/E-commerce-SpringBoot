package com.example.Alfayomi.service;

import com.example.Alfayomi.entity.PromoCode;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PromoCodeServices {
    PromoCode createPromoCode(PromoCode promoCode);
    PromoCode getPromoCode(Long id );
    Double applyPromoCode(Double subtotal , String code);
}
