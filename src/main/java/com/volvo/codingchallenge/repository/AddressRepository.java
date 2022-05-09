package com.volvo.codingchallenge.repository;

import com.volvo.codingchallenge.entity.Address;
import com.volvo.codingchallenge.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Customer> getCustomerByZipCode(@Param("zipCode") String zipCode);
}
