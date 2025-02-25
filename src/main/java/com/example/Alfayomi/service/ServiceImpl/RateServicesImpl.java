package com.example.Alfayomi.service.ServiceImpl;

import com.example.Alfayomi.entity.Product;
import com.example.Alfayomi.entity.Rate;
import com.example.Alfayomi.entity.UserEntity;
import com.example.Alfayomi.exceptions.RecordNotFoundException;
import com.example.Alfayomi.repo.ProductRepo;
import com.example.Alfayomi.repo.RateRepo;
import com.example.Alfayomi.repo.UserRepo;
import com.example.Alfayomi.service.RateServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RateServicesImpl implements RateServices {

    private final RateRepo rateRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    public RateServicesImpl(RateRepo rateRepo, ProductRepo productRepo, UserRepo userRepo) {
        this.rateRepo = rateRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }


    @Override
    public Rate addRating(Long userId, Long productId, Rate rate) {
        log.info("user with id {} add rating to product with id {}" , userId , productId);
        UserEntity user = userRepo.findById(userId).orElseThrow(
                ()-> new RecordNotFoundException("User with id " +  userId + "is not found"));
        log.warn("user with id {} is not found" , userId);
        Product product = productRepo.findById(productId).orElseThrow(
                () -> new RecordNotFoundException("Product not found")
        );
        log.warn("product with id {} is not found" , productId) ;

        rate.setUser(user);
        rate.setProduct(product);
        log.info("rating added successfully");
        return rateRepo.save(rate);
    }

    @Override
    public List<Rate> getRatingByProduct(Long productId) {
        log.info("get all rating with product with id {}" , productId);
        Product product = productRepo.findById(productId).orElseThrow(
                ()-> new RecordNotFoundException("product with id " + productId + "is not found"));
        log.info("product not found");
        return rateRepo.findByProductId(productId);
    }
}
