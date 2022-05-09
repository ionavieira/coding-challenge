package com.volvo.codingchallenge.service;

import com.volvo.codingchallenge.entity.Customer;
import com.volvo.codingchallenge.repository.CustomerRepository;
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

@Service
@AllArgsConstructor
public class CustomerService implements CustomerRepository {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAll(Sort sort) {
        return customerRepository.findAll(sort);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAllById(Iterable<Long> ids) {
        return customerRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> id) {
        customerRepository.deleteAllById(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Customer> customers) {
        customerRepository.deleteAll(customers);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @Override
    public <S extends Customer> S save(S customer) {
        return customerRepository.save(customer);
    }

    @Override
    public <S extends Customer> List<S> saveAll(Iterable<S> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void flush() {
        customerRepository.flush();
    }

    @Override
    public <S extends Customer> S saveAndFlush(S customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> customers) {
        return customerRepository.saveAllAndFlush(customers);
    }

    @Override
    public void deleteAllInBatch(Iterable<Customer> customers) {
        customerRepository.deleteAllInBatch(customers);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> id) {
        customerRepository.deleteAllByIdInBatch(id);
    }

    @Override
    public void deleteAllInBatch() {
        customerRepository.deleteAllInBatch();
    }

    @Override
    public Customer getOne(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public <S extends Customer> Optional<S> findOne(Example<S> example) {
        return customerRepository.findOne(example);
    }

    @Override
    public <S extends Customer> List<S> findAll(Example<S> example) {
        return customerRepository.findAll(example);
    }

    @Override
    public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
        return customerRepository.findAll(example, sort);
    }

    @Override
    public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return customerRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Customer> long count(Example<S> example) {
        return customerRepository.count(example);
    }

    @Override
    public <S extends Customer> boolean exists(Example<S> example) {
        return customerRepository.exists(example);
    }

    @Override
    public <S extends Customer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return customerRepository.findBy(example, queryFunction);
    }
}
