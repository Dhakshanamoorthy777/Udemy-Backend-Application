// OrderService.java
package com.backend.Udemy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Udemy.Dao.OrderDao;
import com.backend.Udemy.dto.OrderResponseDto;
import com.backend.Udemy.entity.Orders;
import com.backend.Udemy.util.ResponseStructure;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public ResponseStructure<OrderResponseDto> saveOrder(Orders order) {

        Orders savedOrder = orderDao.saveOrder(order);

        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(savedOrder.getId());
        dto.setUserId(savedOrder.getUser().getId());
        dto.setTotalAmount(savedOrder.getTotalAmount());
        dto.setStatus(savedOrder.getOrderStatus().name());
        dto.setCreatedAt(savedOrder.getCreatedAt());

        ResponseStructure<OrderResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(201);
        structure.setMessage("Order Created Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<List<Orders>> getAllOrders() {

        ResponseStructure<List<Orders>> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("All Orders Fetched Successfully");
        structure.setData(orderDao.getAllOrders());
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<Orders> findOrderById(Long id) {

        ResponseStructure<Orders> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Order Found Successfully");
        structure.setData(orderDao.findOrderById(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<OrderResponseDto> updateOrder(Orders order) {

        Orders updatedOrder = orderDao.updateOrder(order);

        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(updatedOrder.getId());
        dto.setUserId(updatedOrder.getUser().getId());
        dto.setTotalAmount(updatedOrder.getTotalAmount());
        dto.setStatus(updatedOrder.getOrderStatus().name());
        dto.setCreatedAt(updatedOrder.getCreatedAt());

        ResponseStructure<OrderResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Order Updated Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<String> deleteOrder(Long id) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Order Deleted Successfully");
        structure.setData(orderDao.deleteOrder(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }
}