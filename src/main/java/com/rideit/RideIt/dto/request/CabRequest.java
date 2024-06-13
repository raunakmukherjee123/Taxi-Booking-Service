package com.rideit.RideIt.dto.request;

import com.rideit.RideIt.Enum.CarType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabRequest
{
    String cabNo;
    String company;
    String carModel;
    CarType carType;
    int totalSeats;
    double farePerKm;
}
