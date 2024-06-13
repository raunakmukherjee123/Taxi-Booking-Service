package com.rideit.RideIt.controller;

import com.rideit.RideIt.dto.request.TripBookingRequest;
import com.rideit.RideIt.dto.response.TripBookingResponse;
import com.rideit.RideIt.service.TripBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trip")
public class TripBookingController
{
    private final TripBookingService tripBookingService;
    @PostMapping("/book")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestParam(value = "apply-coupon",required = false) boolean coupon,
                                                      @RequestBody TripBookingRequest bookingRequest)
    {
      TripBookingResponse tripBookingResponse=tripBookingService.bookCab(coupon,bookingRequest);
      return new ResponseEntity<>(tripBookingResponse, HttpStatus.CREATED);
    }
}
