package com.volvo.codingchallenge.service;

import com.volvo.codingchallenge.entity.Address;
import com.volvo.codingchallenge.entity.Customer;
import com.volvo.codingchallenge.repository.AddressRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService implements AddressRepository {

    @Autowired
    AddressRepository addressRepository;
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> findAll(Sort sort) {
        return addressRepository.findAll(sort);
    }

    @Override
    public Page<Address> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }

    @Override
    public List<Address> findAllById(Iterable<Long> id) {
        return addressRepository.findAllById(id);
    }

    @Override
    public long count() {
        return addressRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        addressRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Address> addresses) {
        addressRepository.deleteAll(addresses);
    }

    @Override
    public void deleteAll() {
        addressRepository.deleteAll();
    }

    @Override
    public <S extends Address> S save(S address) {
        return addressRepository.save(address);
    }

    @Override
    public <S extends Address> List<S> saveAll(Iterable<S> addresses) {
        return addressRepository.saveAll(addresses);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return addressRepository.existsById(id);
    }

    @Override
    public void flush() {
        addressRepository.flush();
    }

    @Override
    public <S extends Address> S saveAndFlush(S address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public <S extends Address> List<S> saveAllAndFlush(Iterable<S> addresses) {
        return addressRepository.saveAllAndFlush(addresses);
    }

    @Override
    public void deleteAllInBatch(Iterable<Address> addresses) {
        addressRepository.deleteAllInBatch(addresses);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        addressRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        addressRepository.deleteAllInBatch();
    }

    @Override
    public Address getOne(Long id) {
        return addressRepository.getOne(id);
    }

    @Override
    public Address getById(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public <S extends Address> Optional<S> findOne(Example<S> example) {
        return addressRepository.findOne(example);
    }

    @Override
    public <S extends Address> List<S> findAll(Example<S> example) {
        return addressRepository.findAll(example);
    }

    @Override
    public <S extends Address> List<S> findAll(Example<S> example, Sort sort) {
        return addressRepository.findAll(example, sort);
    }

    @Override
    public <S extends Address> Page<S> findAll(Example<S> example, Pageable pageable) {
        return addressRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Address> long count(Example<S> example) {
        return addressRepository.count(example);
    }

    @Override
    public <S extends Address> boolean exists(Example<S> example) {
        return addressRepository.exists(example);
    }

    @Override
    public <S extends Address, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return addressRepository.findBy(example, queryFunction);
    }

    @Override
    public List<Customer> getCustomerByZipCode(String zipCode) {
       var response =  findAll().stream()
               .filter(address -> address.getZipCode().equals(zipCode)).map(address -> address.getCustomers()).collect(Collectors.toList());
      return response.get(0);
    }

}
