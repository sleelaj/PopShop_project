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

import com.saileela.ecommerce.ecommerce_backend.model.Order;
import com.saileela.ecommerce.ecommerce_backend.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    // Update Order
    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    // Delete Order
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully!";
    }
}
