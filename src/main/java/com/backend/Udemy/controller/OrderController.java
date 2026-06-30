package com.backend.Udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.Udemy.dto.OrderResponseDto;
import com.backend.Udemy.entity.Orders;
import com.backend.Udemy.service.OrderService;
import com.backend.Udemy.util.ResponseStructure;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseStructure<OrderResponseDto> saveOrder(@RequestBody Orders order) {
        return orderService.saveOrder(order);
    }

    @GetMapping
    public ResponseStructure<?> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseStructure<?> findOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PutMapping
    public ResponseStructure<OrderResponseDto> updateOrder(@RequestBody Orders order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}