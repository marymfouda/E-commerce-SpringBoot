package com.example.Alfayomi.controller;

import com.example.Alfayomi.entity.PromoCode;
import com.example.Alfayomi.service.PromoCodeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promo-code")

public class PromoCodeController {

    private final PromoCodeServices promoCodeServices;

    public PromoCodeController(PromoCodeServices promoCodeServices) {
        this.promoCodeServices = promoCodeServices;
    }
    @PostMapping("/create")
    public ResponseEntity<PromoCode> createPromoCode(@Validated @RequestBody PromoCode promoCode){
        PromoCode promoCode1 = promoCodeServices.createPromoCode(promoCode);
        return ResponseEntity.status(HttpStatus.CREATED).body(promoCode1);
    }
    @GetMapping("/get-one/{id}")
    public ResponseEntity<PromoCode> getPromoCodeById(@PathVariable Long id){
        PromoCode promoCode = promoCodeServices.getPromoCode(id);
        return ResponseEntity.ok().body(promoCode);
    }
    @GetMapping("/apply")
    public ResponseEntity<Double> applyPromoCode(
            @RequestParam Double subtotal,
            @RequestParam String code
    ){
        Double priceAfterPromoCode = promoCodeServices.applyPromoCode(subtotal , code);
        return ResponseEntity.ok(priceAfterPromoCode);
    }
}
