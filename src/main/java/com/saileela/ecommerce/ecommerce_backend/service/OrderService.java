package com.saileela.ecommerce.ecommerce_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saileela.ecommerce.ecommerce_backend.model.Order;
import com.saileela.ecommerce.ecommerce_backend.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    // Update Order
    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setQuantity(updatedOrder.getQuantity());
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setProduct(updatedOrder.getProduct());
            order.setCustomer(updatedOrder.getCustomer());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found with ID: " + id);
        }
    }

    // Delete Order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
