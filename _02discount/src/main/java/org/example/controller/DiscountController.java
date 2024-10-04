package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.discount.DiscountRequest;
import org.example.entity.Discount;
import org.example.repository.DiscountRepository;
import org.example.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/coupons")
public class DiscountController {


    private final DiscountRepository discountRepository;

    @Autowired
    private DiscountService discountService;

    public DiscountController(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @GetMapping("/{couponName}")
    public Discount getDiscount(@PathVariable("couponName") String couponName) {
      Discount byCouponName = discountRepository.findByCouponName(couponName);
      return byCouponName;
    }

    @PostMapping
    public ResponseEntity<DiscountRequest> sendDiscount(@RequestBody DiscountRequest discountRequest) {
         discountService.saveDiscount(discountRequest);
        return new ResponseEntity<>(discountRequest, HttpStatus.CREATED);
    }
}
