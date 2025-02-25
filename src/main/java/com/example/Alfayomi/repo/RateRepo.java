package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateRepo extends JpaRepository<Rate , Long> {
    List<Rate> findByProductId(Long productId);
}
