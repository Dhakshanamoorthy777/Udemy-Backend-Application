package com.backend.Udemy.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.backend.Udemy.entity.OrderItem;
import com.backend.Udemy.repository.OrderItemRepository;

@Repository
public class OrderItemDao {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem findOrderItemById(Long id) {
        Optional<OrderItem> optional = orderItemRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("Order Item Id Not Found");
        }
    }

    public OrderItem updateOrderItem(OrderItem orderItem) {
        Optional<OrderItem> optional = orderItemRepository.findById(orderItem.getId());

        if (optional.isPresent()) {
            return orderItemRepository.save(orderItem);
        } else {
            throw new IllegalArgumentException("Order Item Id Not Found");
        }
    }

    public String deleteOrderItem(Long id) {
        Optional<OrderItem> optional = orderItemRepository.findById(id);

        if (optional.isPresent()) {
            orderItemRepository.deleteById(id);
            return "Order Item Deleted Successfully";
        } else {
            throw new IllegalArgumentException("Order Item Id Not Found");
        }
    }

    public Page<OrderItem> getOrderItemsWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return orderItemRepository.findAll(pageable);
    }
}