package com.rideit.RideIt.repository;

import com.rideit.RideIt.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
