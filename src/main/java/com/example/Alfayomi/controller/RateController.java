package com.example.Alfayomi.controller;

import com.example.Alfayomi.entity.Rate;
import com.example.Alfayomi.service.RateServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController{

    private final RateServices rateServices;


    public RateController(RateServices rateServices) {
        this.rateServices = rateServices;
    }
    @PostMapping("/add-rating")
    public ResponseEntity<Rate> addRating(@Validated @RequestParam Long userId ,
                                          @RequestParam Long productId ,
                                          @RequestBody Rate rate){
        Rate rating = rateServices.addRating(userId , productId , rate);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

    @GetMapping("/get-rate/{productId}")
    public ResponseEntity<List<Rate>> getRatingByProduct (@PathVariable Long productId){
        List<Rate> ratingProduct = rateServices.getRatingByProduct(productId);
        return ResponseEntity.ok().body(ratingProduct);
    }
}
