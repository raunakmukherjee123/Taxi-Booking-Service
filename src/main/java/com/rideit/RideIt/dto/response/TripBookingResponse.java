package com.rideit.RideIt.dto.response;

import com.rideit.RideIt.Enum.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBookingResponse {
    String bookingId;
    String source;
    String destination;
    double tripDistanceInKm;
    TripStatus tripStatus;
    Date bookedAt;
    CustomerResponse customerResponse;
    DriverResponse driverResponse;
}
