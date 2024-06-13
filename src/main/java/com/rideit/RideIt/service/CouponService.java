package com.rideit.RideIt.service;

import com.rideit.RideIt.Transformer.CabTransformer;
import com.rideit.RideIt.Transformer.CouponTransformer;
import com.rideit.RideIt.models.Coupon;
import com.rideit.RideIt.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService
{
    private final CouponRepository couponRepository;
    public String addCoupon(String couponCode,int percentage)
    {
        Coupon coupon= CouponTransformer.prepareCoupon(couponCode,percentage);
        couponRepository.save(coupon);
        return "Coupon saved successfully";
    }
}
