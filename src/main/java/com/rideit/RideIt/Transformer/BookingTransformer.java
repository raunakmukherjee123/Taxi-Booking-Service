package com.rideit.RideIt.Transformer;

import com.rideit.RideIt.Enum.TripStatus;
import com.rideit.RideIt.dto.request.TripBookingRequest;
import com.rideit.RideIt.dto.response.CustomerResponse;
import com.rideit.RideIt.dto.response.TripBookingResponse;
import com.rideit.RideIt.models.TripBooking;

import java.util.UUID;

public class BookingTransformer
{
    public static TripBooking BookingRequestToBooking(TripBookingRequest tripBookingRequest)
    {
        return TripBooking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .source(tripBookingRequest.getSource())
                .destination(tripBookingRequest.getDestination())
                .tripDistanceInKm(tripBookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.IN_TRANSIT)
                .build();
    }
    public static TripBookingResponse BookingToBookingResponse(TripBooking tripBooking)
    {
         return TripBookingResponse.builder()
                 .bookingId(String.valueOf(UUID.randomUUID()))
                 .source(tripBooking.getSource())
                 .destination(tripBooking.getDestination())
                 .tripDistanceInKm(tripBooking.getTripDistanceInKm())
                 .tripStatus(tripBooking.getTripStatus())
                 .bookedAt(tripBooking.getBookedAt())
                 .customerResponse(CustomerTransformer.CustomerToCustomerResponse(tripBooking.getCustomer()))
                 .driverResponse(DriverTransformer.DriverToDriverResponse(tripBooking.getDriver()))
                 .build();
    }
}
