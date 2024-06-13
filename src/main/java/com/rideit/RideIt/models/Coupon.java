package com.rideit.RideIt.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "coupon")
@Builder
public class Coupon
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String couponCode;
    int percentageDiscount;
}
