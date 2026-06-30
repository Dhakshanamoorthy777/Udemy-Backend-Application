package com.backend.Udemy.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.backend.Udemy.entity.Orders;
import com.backend.Udemy.repository.OrdersRepository;

@Repository
public class OrderDao {

    @Autowired
    private OrdersRepository ordersRepository;

    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders findOrderById(Long id) {
        Optional<Orders> optional = ordersRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("Order Id Not Found");
        }
    }

    public Orders updateOrder(Orders order) {
        Optional<Orders> optional = ordersRepository.findById(order.getId());

        if (optional.isPresent()) {
            return ordersRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order Id Not Found");
        }
    }

    public String deleteOrder(Long id) {
        Optional<Orders> optional = ordersRepository.findById(id);

        if (optional.isPresent()) {
            ordersRepository.deleteById(id);
            return "Order Deleted Successfully";
        } else {
            throw new IllegalArgumentException("Order Id Not Found");
        }
    }

    public Page<Orders> getOrdersWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return ordersRepository.findAll(pageable);
    }
}