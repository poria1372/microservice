package org.example.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRequest {
    private Long id;
    private BigDecimal coupon;
    private String couponName;
    private String expireDate;
}
