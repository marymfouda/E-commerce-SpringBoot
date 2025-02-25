package com.example.Alfayomi.controller;

import com.example.Alfayomi.entity.Product;
import com.example.Alfayomi.service.ProductServices;
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
    @GetMapping("/getProductByCategory")
    public ResponseEntity<List<Product>> getProductByCategory(){
        List<Product> product = productServices.getAllProduct();
        return ResponseEntity.ok(product);
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
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

        Product product = productServices.getProduct(id);
        productServices.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id " + id + " deleted successfully");

    }



}
