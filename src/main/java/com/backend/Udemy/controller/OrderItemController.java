// OrderItemController.java
package com.backend.Udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.Udemy.dto.OrderItemResponseDto;
import com.backend.Udemy.entity.OrderItem;
import com.backend.Udemy.service.OrderItemService;
import com.backend.Udemy.util.ResponseStructure;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public ResponseStructure<OrderItemResponseDto> saveOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }

    @GetMapping
    public ResponseStructure<?> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public ResponseStructure<?> findOrderItemById(@PathVariable Long id) {
        return orderItemService.findOrderItemById(id);
    }

    @PutMapping
    public ResponseStructure<OrderItemResponseDto> updateOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.updateOrderItem(orderItem);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteOrderItem(@PathVariable Long id) {
        return orderItemService.deleteOrderItem(id);
    }
}