package com.rideit.RideIt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rideit.RideIt.Enum.CarType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "cab_details")
@Builder
public class Cab
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true,nullable = false)
    String cabNo;
    String company;
    boolean available;
    String carModel;
    @Enumerated(EnumType.STRING)
    CarType carType;
    int totalSeats;
    double farePerKm;
    @OneToOne
    @JoinColumn// on whichever class I write @JoinColumn, that class will have foreign key ONLY
    @JsonIgnore// to avoid jackson infinite recursion. It stops serialization/deserialization of the attribute
    Driver driver;
}
