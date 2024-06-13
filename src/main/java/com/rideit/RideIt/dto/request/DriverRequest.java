package com.rideit.RideIt.dto.request;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverRequest
{
    String name;
    int age;
    String panNo;
    String mobile;
    CabRequest cabRequest;// it is a good idea to create dto of cab and store it in DriverRequest for security purpose as we
    //don't want to expose all details
}
