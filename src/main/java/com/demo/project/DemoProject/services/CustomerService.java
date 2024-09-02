package com.demo.project.DemoProject.services;

import com.demo.project.DemoProject.entity.Customers;
import com.demo.project.DemoProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customers> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customers createCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}