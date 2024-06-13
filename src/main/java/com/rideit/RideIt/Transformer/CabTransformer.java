package com.rideit.RideIt.Transformer;

import com.rideit.RideIt.dto.request.CabRequest;
import com.rideit.RideIt.dto.response.CabResponse;
import com.rideit.RideIt.models.Cab;

public class CabTransformer
{
    public static Cab CabRequestToCab(CabRequest cabRequest)
    {
        Cab cab=Cab.builder()
                .cabNo(cabRequest.getCabNo())
                .carModel(cabRequest.getCarModel())
                .company(cabRequest.getCompany())
                .carType(cabRequest.getCarType())
                .totalSeats(cabRequest.getTotalSeats())
                .farePerKm(cabRequest.getFarePerKm())
                .available(true)
                .build();
        return cab;
    }
    public static CabResponse CabToCabResponse(Cab cab)
    {
        return CabResponse.builder()
                .cabNo(cab.getCabNo())
                .cabModel(cab.getCarModel())
                .farePerKm(cab.getFarePerKm())
                .build();
    }
}
