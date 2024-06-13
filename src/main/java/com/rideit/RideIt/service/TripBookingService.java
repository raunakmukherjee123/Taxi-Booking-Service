package com.rideit.RideIt.service;

import com.rideit.RideIt.Transformer.BookingTransformer;
import com.rideit.RideIt.dto.request.TripBookingRequest;
import com.rideit.RideIt.dto.response.TripBookingResponse;
import com.rideit.RideIt.exception.CabNotFoundException;
import com.rideit.RideIt.exception.CustomerNotFoundException;
import com.rideit.RideIt.models.*;
import com.rideit.RideIt.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {
    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private final TripBookingRepository tripBookingRepository;

    private final CouponRepository couponRepository;
    public TripBookingResponse bookCab(boolean coupon,TripBookingRequest bookingRequest)
    {
      // validate emailId of customer
        Customer customer=customerRepository.findByEmail(bookingRequest.getCustomerEmail());
        if(customer==null)
        {
            throw new CustomerNotFoundException("Customer of this email-id does not exist");
        }

        //get a random cab and then check whether that cab is available or not
        Cab cab=cabRepository.getRandomCab();
        if(cab==null)
        {
            throw  new CabNotFoundException("No cab is available right now");
        }
        TripBooking tripBooking= BookingTransformer.BookingRequestToBooking(bookingRequest);
        double totalFare=cab.getFarePerKm() * tripBooking.getTripDistanceInKm();
        if(coupon==true)
        {
            Coupon coupon1=couponRepository.getCoupon();
            int discount=coupon1.getPercentageDiscount();
            double amount= totalFare-((totalFare*discount)/100);
            tripBooking.setTotalFare(amount);
        }
        else {
            tripBooking.setTotalFare(totalFare);
        }
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());
        TripBooking savedTripBooking=tripBookingRepository.save(tripBooking);  //  ******************
        customer.getTripBookingList().add(savedTripBooking);
        cab.setAvailable(false);
        cab.getDriver().getBookingList().add(savedTripBooking);
        customerRepository.save(customer);// customer is parent class of booking. So save it in here. it will save both
                                      // customer and booking as they have cascade relationship

        driverRepository.save(cab.getDriver()); // driver, cab and booking will be saved together for same reason as above

        /*

        note: since booking is saved twice through driver and customer, so there will be multiple same data since booking
        don't have primary key yet. so save it in bookrepository and store it in savedTripBooking. this will have primary
        key. Now, when booking is saved many times, it will overwrite everytime

        */

        return BookingTransformer.BookingToBookingResponse(savedTripBooking);
    }
}
