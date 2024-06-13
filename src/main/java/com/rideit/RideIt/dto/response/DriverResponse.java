package com.rideit.RideIt.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DriverResponse
{
    String name;
    String mobile;
    double rating;
    CabResponse cabResponse;
}
