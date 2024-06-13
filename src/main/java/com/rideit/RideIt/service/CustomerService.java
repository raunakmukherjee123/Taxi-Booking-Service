package com.rideit.RideIt.service;

import com.rideit.RideIt.Enum.Gender;
import com.rideit.RideIt.Transformer.BookingTransformer;
import com.rideit.RideIt.Transformer.CustomerTransformer;
import com.rideit.RideIt.dto.request.CustomerRequest;
import com.rideit.RideIt.dto.response.CustomerResponse;
import com.rideit.RideIt.dto.response.TripBookingResponse;
import com.rideit.RideIt.models.Customer;
import com.rideit.RideIt.models.Driver;
import com.rideit.RideIt.models.TripBooking;
import com.rideit.RideIt.repository.CustomerRepository;
import com.rideit.RideIt.repository.DriverRepository;
import com.rideit.RideIt.repository.TripBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService
{
//    @Autowired
//    CustomerRepository customerRepository;
    private final CustomerRepository customerRepository;
    private final TripBookingRepository tripBookingRepository;
    private final DriverRepository driverRepository;

   // public CustomerService(CustomerRepository customerRepository) {
   //     this.customerRepository = customerRepository;
  //  }

    public CustomerResponse addCustomer(CustomerRequest customerRequest)
    {
        //through dto I am setting details in Model class and then save it to database
     //  Customer customer=new Customer();
//        customer.setAge(customerRequest.getAge());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setName(customerRequest.getName());
//        customer.setAddress(customerRequest.getAddress());
//        customer.setGender(customerRequest.getGender());

      // below is same as above

//       Customer customer= Customer.builder()
//                         .name(customerRequest.getName())
//                         .age(customerRequest.getAge())                //this is Builder in spring
//                         .email(customerRequest.getEmail())           //Builder is part of lombok, It is used to create
//                                                                     // object in a fancy way.
//                         .address(customerRequest.getAddress())
//                         .gender(customerRequest.getGender())
//                         .build();
          //instead of writing here make a function in transformer class and implement this logic
        Customer customer= CustomerTransformer.CustomerRequestToCustomer(customerRequest);


        Customer savedCustomer=customerRepository.save(customer);


//        CustomerResponse customerResponse=CustomerResponse.builder()
//                                         .name(customer.getName())
//                                         .age(customer.getAge())
//                                         .gender(customer.getGender())
//                                         .build();
        CustomerResponse customerResponse=CustomerTransformer.CustomerToCustomerResponse(savedCustomer);
        return customerResponse;
    }

    public List<CustomerResponse> get(String gender, int age)
    {
        List<Customer> customers=customerRepository.findByGenderAndAge(gender,age);
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers)
        {
            customerResponses.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public String rating(String bookingId, double rate)
    {
        TripBooking tripBooking=tripBookingRepository.findByBookingId(bookingId);
       Driver driver=tripBooking.getDriver();
       driver.setRating(rate);
       driverRepository.save(driver);
       String name=tripBooking.getDriver().getName();
        return "you have given "+rate+" to "+name;
    }
}
