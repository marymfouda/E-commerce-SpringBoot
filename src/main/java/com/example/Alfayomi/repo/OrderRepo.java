package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<UserOrder, Long> {
}
