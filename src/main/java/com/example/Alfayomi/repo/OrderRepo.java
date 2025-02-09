package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
