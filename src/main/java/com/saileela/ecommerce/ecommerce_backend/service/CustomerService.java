package com.saileela.ecommerce.ecommerce_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saileela.ecommerce.ecommerce_backend.model.Customer;
import com.saileela.ecommerce.ecommerce_backend.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update Customer
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhone(updatedCustomer.getPhone());
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
    }

    // Delete Customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

