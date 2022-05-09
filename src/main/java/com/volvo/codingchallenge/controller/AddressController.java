package com.volvo.codingchallenge.controller;

import com.volvo.codingchallenge.entity.Address;
import com.volvo.codingchallenge.entity.Customer;
import com.volvo.codingchallenge.exception.AddressNotFoundException;
import com.volvo.codingchallenge.service.AddressService;
import com.volvo.codingchallenge.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @Autowired
    CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Search all address")
    public List<Address> searchAllAddress(Pageable pageable) {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(
            @PathVariable Long id) {
        return ResponseEntity.ok(addressService.findById(id).orElseThrow(RuntimeException::new));
    }


    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete address by Id")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id) {
        return addressService.findById(id).map(usuario -> {
            addressService.delete(usuario);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new AddressNotFoundException("Address not found."));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete addresses")
    public void deleteAll() {
        addressService.deleteAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new Address")
    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address){

        List<Customer> customers = address.getCustomers();
        LocalDate todayDate = LocalDate.now();

        for(Customer c : customers){
            c.setRegistrationDate(Date.from(todayDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        //Save customer before the address
        var savedCustomer = customerService.saveAll(customers);
        //add the customers with createdId in the address
        address.setCustomers(savedCustomer);
        var savedAddress = addressService.save(address);

        return ResponseEntity.ok(savedAddress);

    }

    @GetMapping("/zipCode/{zipCode}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getCustomerByZipCode(
            @PathVariable String zipCode) {
        return ResponseEntity.ok(addressService.getCustomerByZipCode(zipCode));
    }

}
