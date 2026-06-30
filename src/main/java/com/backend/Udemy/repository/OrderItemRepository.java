package com.backend.Udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.Udemy.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}