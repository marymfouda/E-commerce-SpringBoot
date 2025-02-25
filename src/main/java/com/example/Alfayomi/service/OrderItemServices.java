package com.example.Alfayomi.service;

public interface OrderItemServices {
    void addItemToOrder(Long orderId, Long productId, int quantity);
}
