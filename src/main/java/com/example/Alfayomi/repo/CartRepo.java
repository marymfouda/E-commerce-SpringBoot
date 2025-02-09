package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart , Long> {
}
