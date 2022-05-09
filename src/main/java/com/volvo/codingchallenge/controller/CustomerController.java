package com.volvo.codingchallenge.controller;

import com.volvo.codingchallenge.entity.Address;
import com.volvo.codingchallenge.entity.Customer;
import com.volvo.codingchallenge.exception.CustomerNotFoundException;
import com.volvo.codingchallenge.service.AddressService;
import com.volvo.codingchallenge.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    AddressService addressService;
    @Autowired
    CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Search all customers")
    public List<Customer> searchAllCustomers(Pageable pageable) {
        return customerService.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(
            @PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id).orElseThrow(RuntimeException::new));
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete customer by Id")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id) {
        return customerService.findById(id).map(customer -> {
            customerService.delete(customer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new CustomerNotFoundException());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new Customer")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        List<Address> addresses = customer.getAddresses();
        LocalDate todayDate = LocalDate.now();
        customer.setRegistrationDate(Date.from(todayDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        var savedAddresses = addressService.saveAll(addresses);
        customer.setAddresses(savedAddresses);
        var savedCustomer = customerService.save(customer);

        return ResponseEntity.ok(savedCustomer);

    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete customers")
    public void deleteAll() {
        customerService.deleteAll();
    }





}
