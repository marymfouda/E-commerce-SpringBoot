package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem , Long> {
}
