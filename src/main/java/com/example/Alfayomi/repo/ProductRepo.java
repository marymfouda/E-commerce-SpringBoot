package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product , Long> {
}
