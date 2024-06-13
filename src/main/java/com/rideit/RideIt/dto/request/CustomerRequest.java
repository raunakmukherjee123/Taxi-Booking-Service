package com.rideit.RideIt.dto.request;

import com.rideit.RideIt.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest
{
    String name;
    int age;
    String email;
    String address;
    Gender gender;
}
