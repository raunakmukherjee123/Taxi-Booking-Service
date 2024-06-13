package com.rideit.RideIt.controller;

import com.rideit.RideIt.models.Coupon;
import com.rideit.RideIt.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController
{
    private final CouponService couponservice;
    @PostMapping
    public ResponseEntity<String> addCoupon(@RequestParam("coupon-code")String couponCode,
                                            @RequestParam("coupon-percentage")int percentage)
    {
        String res=couponservice.addCoupon(couponCode,percentage);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
