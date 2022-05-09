package com.volvo.codingchallenge.repository;

import com.volvo.codingchallenge.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
