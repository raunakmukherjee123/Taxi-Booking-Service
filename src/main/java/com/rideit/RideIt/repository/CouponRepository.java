package com.rideit.RideIt.repository;

import com.rideit.RideIt.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CouponRepository extends JpaRepository<Coupon,Integer>
{
    @Query(value = "select * from coupon order by rand() limit 1",nativeQuery = true)
   Coupon getCoupon();
}
