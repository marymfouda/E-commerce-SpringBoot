package com.example.Alfayomi.controller;

import com.example.Alfayomi.entity.Product;
import com.example.Alfayomi.service.ProductServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/Product")
@Slf4j
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> product = productServices.getAllProduct();
        return ResponseEntity.ok(product);
    }
    @GetMapping("/getProductByCategory/{type}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String type){
        List<Product> product = productServices.getProductByCategory(type);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/getProductByPrice")
    public ResponseEntity<List<Product>> getProductByPrice(@RequestParam float minPrice ,
                                                           @RequestParam float maxPrice){
        List<Product> products = productServices.getProductByPrice(minPrice, maxPrice);
        return ResponseEntity.ok().body(products);
    }
    public ResponseEntity<List<Product>> getProductByCategoryAndPrice(@RequestParam String type ,
                                                                      @RequestParam float minPrice ,
                                                                      @RequestParam float maxPrice){
        List<Product> filterProducts = productServices.getProductByCategoryAndPrice(type, minPrice, maxPrice);
        return ResponseEntity.ok().body(filterProducts);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        Product product = productServices.getProduct(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/get/paginationAndSort/{offset}/{pageSize}/{field}")
    public ResponseEntity<Page<Product>> getAllProductWithPaginationAndSort(@PathVariable int offset , @PathVariable int pageSize , @PathVariable String field ){
        Page<Product> products = productServices.findAllWithPaginationAndSort(offset, pageSize , field);
        return ResponseEntity.ok(products);
    }
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) throws IOException {
        Product product1 = productServices.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id , @RequestBody Product product){
        Product updateProduct = productServices.updateProduct(id , product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product updated successfully ");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        Product product = productServices.getProduct(id);
        productServices.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id " + id + " deleted successfully");

    }
}
