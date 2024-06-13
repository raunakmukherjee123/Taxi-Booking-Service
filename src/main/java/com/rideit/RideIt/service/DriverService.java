package com.rideit.RideIt.service;

import com.rideit.RideIt.Transformer.CabTransformer;
import com.rideit.RideIt.Transformer.DriverTransformer;
import com.rideit.RideIt.dto.request.CabRequest;
import com.rideit.RideIt.dto.request.DriverRequest;
import com.rideit.RideIt.models.Cab;
import com.rideit.RideIt.models.Driver;
import com.rideit.RideIt.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //provides all possible combinations of constructor with given fields
public class DriverService {
//    @Autowired
//    DriverRepository driverRepository;
    private  final DriverRepository driverRepository;

//    public DriverService(DriverRepository driverRepository) {
//        this.driverRepository = driverRepository;
//    }
                //if @RequiredArgsConstructor is written, then no need  to write the above


    public String add(DriverRequest driverRequest)
    {
        //get cabrequest object from driverrequest
        CabRequest cabRequest=driverRequest.getCabRequest();
        // convert cabRequest to cab
        //driverRequest to driver
        Driver driver= DriverTransformer.DriverRequestToDriver(driverRequest);
        Cab cab= CabTransformer.CabRequestToCab(cabRequest);


        //set the relationship attributes
        driver.setCab(cab);
        cab.setDriver(driver);
        driverRepository.save(driver);

        return "Driver and Cab saved sucessfully";
    }
}
