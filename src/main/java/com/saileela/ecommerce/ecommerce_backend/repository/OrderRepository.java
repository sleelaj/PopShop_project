package com.saileela.ecommerce.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saileela.ecommerce.ecommerce_backend.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
