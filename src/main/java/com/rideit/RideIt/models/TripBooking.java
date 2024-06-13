package com.rideit.RideIt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rideit.RideIt.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBooking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId;

    String source;

    String destination;

    double tripDistanceInKm;

    double totalFare;

    @Enumerated(EnumType.STRING)
    TripStatus tripStatus;

    @CreationTimestamp//every time we store records in database, mysql will populate the values of "bookedAt"
    Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore// to avoid jackson infinite recursion. It stops serialization/deserialization of the attribute
    Customer customer;

    @ManyToOne
    @JoinColumn
    @JsonIgnore// to avoid jackson infinite recursion. It stops serialization/deserialization of the attribute
    Driver driver;
}
//Date of sql package --> Date
//Date of util package --> Dtae + Timestamp
