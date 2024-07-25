package com.example.customermanageexceptionhandler.service.impl;

import com.example.customermanageexceptionhandler.exception.DuplicateEmailException;
import com.example.customermanageexceptionhandler.model.Customer;
import com.example.customermanageexceptionhandler.repository.ICustomerRepository;
import com.example.customermanageexceptionhandler.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
