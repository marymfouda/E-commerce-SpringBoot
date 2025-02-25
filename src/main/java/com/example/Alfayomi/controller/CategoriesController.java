package com.example.Alfayomi.controller;
import com.example.Alfayomi.entity.Categories;
import com.example.Alfayomi.service.CategoriesServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
@Slf4j
public class CategoriesController {

    private final CategoriesServices categoriesServices;

    public CategoriesController(CategoriesServices categoriesServices) {
        this.categoriesServices = categoriesServices;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Categories>> getAllCategories(){
        List<Categories> categories = categoriesServices.getAllCategories();
        return ResponseEntity.ok(categories);

    }
    @GetMapping("/getCategory/{id}")
    public ResponseEntity<Categories> getCategory(@PathVariable Long id){
        Categories categories = categoriesServices.getCategory(id);
        return ResponseEntity.ok(categories);
    }
    @PostMapping("/create")
    public ResponseEntity<Categories> createCategory(@RequestBody Categories categories){
        Categories categories1 = categoriesServices.createCategories(categories);
        return ResponseEntity.status(HttpStatus.CREATED).body(categories);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id , @RequestBody Categories categories){
        Categories categories1 = categoriesServices.updateCategories( id , categories);
        return ResponseEntity.status(HttpStatus.CREATED).body("category with id " + id + " created successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id ){
        Categories categories = categoriesServices.getCategory(id);
        categoriesServices.deleteCategories(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("category with id " + id + " deleted successfully");
    }
}
