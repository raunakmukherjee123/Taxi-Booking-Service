package com.rideit.RideIt.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class TripBookingRequest
{
    String source;
    String destination;
    double tripDistanceInKm;
    String customerEmail;
}
