package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromoCodeRepo extends JpaRepository<PromoCode , Long> {
    Optional<PromoCode> findByCode(String code);
}
