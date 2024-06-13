package com.rideit.RideIt.models;

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
@Table(name = "driver")
@Builder
public class Driver
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    String panNo;
    @Column(unique = true,nullable = false)
    String mobile;
    double rating;
    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<TripBooking> bookingList=new ArrayList<>();
}
// (mappedBy="driver)-->then it will not create foreign key in "driver" table as it tells hibernate that it already
                       // created foreign key of "driver" class in "cab" class
// (cascade=CascadeType.ALL) --> Whenever I use any database operations on parent class/table, it should also be
                               // reflected on child class/table