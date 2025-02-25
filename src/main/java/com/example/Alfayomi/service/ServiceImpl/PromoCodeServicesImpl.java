package com.example.Alfayomi.service.ServiceImpl;

import com.example.Alfayomi.entity.PromoCode;
import com.example.Alfayomi.exceptions.RecordNotFoundException;
import com.example.Alfayomi.repo.PromoCodeRepo;
import com.example.Alfayomi.service.PromoCodeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class PromoCodeServicesImpl implements PromoCodeServices {
    private final PromoCodeRepo promoCodeRepo;

    public PromoCodeServicesImpl(PromoCodeRepo promoCodeRepo) {
        this.promoCodeRepo = promoCodeRepo;
    }


    @Override
    public PromoCode createPromoCode(PromoCode promoCode) {
        log.info("create new promoCode");
        Optional <PromoCode> promoCodee = promoCodeRepo.findByCode(promoCode.getCode());
        if(promoCodee.isPresent()){
            log.warn("code already exist");
            throw new IllegalStateException("promoCode already exist ");
        }else {
           return promoCodeRepo.save(promoCode);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PromoCode getPromoCode(Long id) {
        log.info("get promoCode by id {}" , id);
        Optional<PromoCode> promoCode = promoCodeRepo.findById(id);
        if(promoCode.isPresent()){
            return promoCode.get();
        }else {
            log.warn("promoCode not found");
           throw new RecordNotFoundException("promoCode with id " + id + "is not exist");
        }
    }

    @Override
    @Transactional
    public Double applyPromoCode(Double subtotal, String code) {
        Optional<PromoCode> promoCode = promoCodeRepo.findByCode(code);
        if(promoCode.isPresent()){
            PromoCode promoCode1 = promoCode.get();
            log.error("promoCode has expired");
            if(promoCode1.getExpiryDate().isBefore(LocalDateTime.now())){
                throw new RuntimeException("Code has expired");
            }
            if("PERCENTAGE".equals(promoCode1.getDiscountType())){
                log.info("apply promoCode with PERCENTAGE type");
                return subtotal - (subtotal * (promoCode1.getDiscount() / 100));
            } else if ("FIXED".equals(promoCode1.getDiscountType())) {
                log.info("apply promoCode with Fixed type");
                return subtotal - promoCode1.getDiscount();
            }
        }
        return subtotal;
    }
}
