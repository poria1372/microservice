package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "coupon")
    @NonNull
    private BigDecimal coupon;
    @Column(name = "couponName")
    @NonNull
    private String couponName;
    @Column(name = "expireDate")
    @JsonProperty("expireDate")
    private String expireDate;

    public Discount() {

    }
}
