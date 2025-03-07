package com.saileela.ecommerce.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saileela.ecommerce.ecommerce_backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
