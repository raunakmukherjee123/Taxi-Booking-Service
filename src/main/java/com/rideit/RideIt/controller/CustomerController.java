package com.rideit.RideIt.controller;

import com.rideit.RideIt.Enum.Gender;
import com.rideit.RideIt.dto.request.CustomerRequest;
import com.rideit.RideIt.dto.response.CustomerResponse;
import com.rideit.RideIt.service.CustomerService;
import com.rideit.RideIt.service.TripBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController
{
//    @Autowired
//    CustomerService customerService;
    private final CustomerService customerService;

   // public CustomerController(CustomerService customerService) {
    //    this.customerService = customerService;
   // }

    private final TripBookingService tripBookingService;

    @PostMapping
     public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest)
    {
      CustomerResponse response=customerService.addCustomer(customerRequest);
      return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity<List<CustomerResponse>> findByGenderAndAge(@PathVariable("gender")String gender,
                                                                     @PathVariable("age")int age)
    {
        List<CustomerResponse> customerResponses=customerService.get(gender,age);
        return new ResponseEntity<>(customerResponses,HttpStatus.OK);
    }
    @PutMapping("/set-rating/")
    public String rating(@RequestParam String bookingId,@RequestParam double rate)
    {
        String res=customerService.rating(bookingId,rate);
        return res;
    }
}
