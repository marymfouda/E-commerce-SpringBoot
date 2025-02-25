package com.example.Alfayomi.repo;

import com.example.Alfayomi.entity.Categories;
import com.example.Alfayomi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {

    Optional<Product> findByName(String name);
    @Query("SELECT a FROM Product a WHERE a.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceBetween(@Param("minPrice")float minPrice ,
                                     @Param("maxPrice") float maxPrice);

    @Query("SELECT a FROM Product a WHERE a.category.type = :categoryType")
    List<Product> findByCategory(@Param("categoryType") String categoryType);

    @Query("SELECT a FROM Product a WHERE a.category.type = :categoryId AND a.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByCategoryIdAndPriceBetween(@Param("categoryType") String categoryType,
                                                  @Param("minPrice") float minPrice,
                                                  @Param("maxPrice") float maxPrice);

}
