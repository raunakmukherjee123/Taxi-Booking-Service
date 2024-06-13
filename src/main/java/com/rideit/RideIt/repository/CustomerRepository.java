package com.rideit.RideIt.repository;

import com.rideit.RideIt.Enum.Gender;
import com.rideit.RideIt.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
  //nativeQuery means original SQL query. By default nativeQuery=false, as it expects you to write in HQL
  //but if nativeQuery=true, that means you will write in SQL
    @Query(value = "select * from customer where gender=:gender and age>=:age",nativeQuery = true)
    List<Customer>  findByGenderAndAge(String gender,Integer age);

    Customer findByEmail(String email);
}
