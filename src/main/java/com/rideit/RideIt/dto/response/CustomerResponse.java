package com.rideit.RideIt.dto.response;

import com.rideit.RideIt.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse
{
    String name;
    int age;
    Gender gender;
}
