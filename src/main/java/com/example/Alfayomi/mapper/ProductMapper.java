package com.example.Alfayomi.mapper;

import com.example.Alfayomi.dto.ProductDTO;
import com.example.Alfayomi.entity.Product;

import static com.example.Alfayomi.dto.ProductDTO.*;

public class ProductMapper {

    public static ProductDTO fromEntityToDto(Product product){
        return builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .stock(product.getStock())
//                .productImages(product.getProductImages())
                .build();
    }
}
