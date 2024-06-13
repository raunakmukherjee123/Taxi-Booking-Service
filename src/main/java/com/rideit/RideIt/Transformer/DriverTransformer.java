package com.rideit.RideIt.Transformer;

import com.rideit.RideIt.dto.request.DriverRequest;
import com.rideit.RideIt.dto.response.DriverResponse;
import com.rideit.RideIt.models.Driver;

public class DriverTransformer
{
    public static Driver DriverRequestToDriver(DriverRequest driverRequest)
    {
        Driver driver=Driver.builder()
                .age(driverRequest.getAge())
                .name(driverRequest.getName())
                .panNo(driverRequest.getPanNo())
                .mobile(driverRequest.getMobile())
                .rating(0)// rating initially as 0
                .build();
        return driver;
    }
    public static DriverResponse DriverToDriverResponse(Driver driver)
    {
        return DriverResponse.builder()
                .name(driver.getName())
                .mobile(driver.getMobile())
                .rating(driver.getRating())
                .cabResponse(CabTransformer.CabToCabResponse(driver.getCab()))
                .build();
    }
}
