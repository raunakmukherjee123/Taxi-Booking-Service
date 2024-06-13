package com.rideit.RideIt.Transformer;

import com.rideit.RideIt.dto.request.CustomerRequest;
import com.rideit.RideIt.dto.response.CustomerResponse;
import com.rideit.RideIt.models.Customer;

public class CustomerTransformer
{
    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest)
    {
        Customer customer= Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())                //this is Builder in spring
                .email(customerRequest.getEmail())           //Builder is part of lombok, It is used to create
                                                            // object in a fancy way.
                .address(customerRequest.getAddress())
                .gender(customerRequest.getGender())
                .build();
        return customer;
    }
    public static CustomerResponse CustomerToCustomerResponse(Customer customer)
    {
        CustomerResponse customerResponse=CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .gender(customer.getGender())
                .build();
        return  customerResponse;
    }
}
