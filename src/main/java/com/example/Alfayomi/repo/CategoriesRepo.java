package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Categories , Long> {
}
