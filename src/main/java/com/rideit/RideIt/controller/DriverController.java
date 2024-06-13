package com.rideit.RideIt.controller;

import com.rideit.RideIt.dto.request.DriverRequest;
import com.rideit.RideIt.service.CustomerService;
import com.rideit.RideIt.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController
{
//    @Autowired
//    DriverService driverService;  ---> this is Field Injection
    private final DriverService driverService;
    DriverController(DriverService driverService)  // ---> constructor injection
    {
        this.driverService=driverService;
    }
    @PostMapping
    public ResponseEntity add(@RequestBody DriverRequest driverRequest)
    {
        String res=driverService.add(driverRequest);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //to do--> delete driver based on mobile number (also in the process, its cab detail will also be deleted)
}
