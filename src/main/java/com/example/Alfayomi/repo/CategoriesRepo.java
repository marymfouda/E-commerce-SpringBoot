package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepo extends JpaRepository<Categories , Long> {

    Optional<Categories> findByType(String type);

}
