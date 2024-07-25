package com.example.customermanageexceptionhandler.service;

import com.example.customermanageexceptionhandler.exception.DuplicateEmailException;
import com.example.customermanageexceptionhandler.model.Customer;

import java.util.List;

public interface IGenerateService<T> {
    List<Customer> findAll();

    void save(Customer customer) throws DuplicateEmailException;

    T findById(Long id);

    void remove(Long id);
}
