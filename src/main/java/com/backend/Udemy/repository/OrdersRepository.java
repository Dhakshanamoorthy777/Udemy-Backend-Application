package com.backend.Udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.Udemy.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}