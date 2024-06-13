package com.rideit.RideIt.dto.response;

import com.rideit.RideIt.Enum.CarType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabResponse
{
  String cabNo;
  String cabModel;
   double farePerKm;
}
