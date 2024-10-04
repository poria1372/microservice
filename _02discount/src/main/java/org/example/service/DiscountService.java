package org.example.service;

import org.example.discount.DiscountRequest;
import org.example.entity.Discount;
import org.example.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public DiscountRequest saveDiscount(DiscountRequest discountRequest) {
        Discount discount = new Discount();
        discount.setCoupon(discountRequest.getCoupon());
        discount.setExpireDate(discountRequest.getExpireDate());
        discount.setCouponName(discountRequest.getCouponName());
        discountRepository.save(discount);
        return discountRequest;

    }

}
