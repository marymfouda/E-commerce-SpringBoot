package com.example.Alfayomi.service;

import com.example.Alfayomi.entity.Rate;

import java.util.List;

public interface RateServices {
    Rate addRating (Long userId , Long productId , Rate rate);
    List<Rate> getRatingByProduct(Long productId);

}
