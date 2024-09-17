package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal coupon;

}
