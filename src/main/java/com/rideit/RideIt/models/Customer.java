package com.rideit.RideIt.models;

import com.rideit.RideIt.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customer")//good practice to create name for the table
@Builder
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    @Column(unique = true,nullable = false)
    String email;
    String address;
    @Enumerated(EnumType.STRING)//jpa maps integer value(0,1,2) in database as the value of gender. So @Enumerated is used
    //to map the original value written in enum class
    Gender gender;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList=new ArrayList<>();
}
//if i don't write  @JoinColumn in OnetoMany then it will create new table containing primary key
// of both classes as columns name