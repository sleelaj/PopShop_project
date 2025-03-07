package com.saileela.ecommerce.ecommerce_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saileela.ecommerce.ecommerce_backend.model.Customer;
import com.saileela.ecommerce.ecommerce_backend.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    // Update Customer
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    // Delete Customer
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully!";
    }
}

