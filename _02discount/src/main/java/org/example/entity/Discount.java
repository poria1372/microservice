package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String name;
    @Column(name = "coupon")
    @NonNull
    private BigDecimal coupon;
    @Column(name = "couponName")
    @NonNull
    private String couponName;
    @Column(name = "expireDate")
    @JsonProperty("expireDate")
    private String expireDate;

}
