package org.example.discount;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("DISCOUNT")
public interface DiscountClient {

    @GetMapping("/api/v1/coupons/{couponName}")
    DiscountRequest getDiscount(@PathVariable("couponName") String couponName);

    @PostMapping("/api/v1/coupons")
    void sendDiscount(@RequestBody DiscountRequest discountRequest);
}
