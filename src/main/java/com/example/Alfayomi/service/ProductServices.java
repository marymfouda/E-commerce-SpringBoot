package com.example.Alfayomi.service;

import com.example.Alfayomi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface ProductServices {

    List<Product> getAllProduct();
    Page<Product> findAllWithPaginationAndSort(int offset , int pageSize , String field);
    Product getProduct(Long id);
    List<Product> getProductByCategory(String type );
    List<Product> getProductByCategoryAndPrice(Long id , float minPrice , float maxPrice);
    List<Product> getProductByPrice(float minPrice , float maxPrice);
    Product createProduct(Product product) throws IOException;
    Product updateProduct(Long id , Product product);
    void deleteProduct(Long id );

}

