package com.example.Alfayomi.service;

import com.example.Alfayomi.entity.Categories;

import java.util.List;

public interface CategoriesServices {

    List<Categories> getAllCategories();
    Categories createCategories(Categories categories);
    Categories getCategory(Long id );
    Categories updateCategories(Long id , Categories categories);
    void deleteCategories(Long id);
}
