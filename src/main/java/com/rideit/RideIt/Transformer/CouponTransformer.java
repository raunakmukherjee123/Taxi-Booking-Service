package com.rideit.RideIt.Transformer;

import com.rideit.RideIt.models.Coupon;

public class CouponTransformer
{
    public static Coupon prepareCoupon(String couponCode,int percentage)
    {
        Coupon coupon=Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(percentage)
                .build();

        return coupon;
    }
}
