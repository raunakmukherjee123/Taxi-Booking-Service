package com.rideit.RideIt.repository;

import com.rideit.RideIt.models.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripBookingRepository extends JpaRepository<TripBooking,String>
{
    TripBooking findByBookingId(String bookingId);
}
