// OrderItemService.java
package com.backend.Udemy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Udemy.Dao.OrderItemDao;
import com.backend.Udemy.dto.OrderItemResponseDto;
import com.backend.Udemy.entity.OrderItem;
import com.backend.Udemy.util.ResponseStructure;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    public ResponseStructure<OrderItemResponseDto> saveOrderItem(OrderItem orderItem) {

        OrderItem savedItem = orderItemDao.saveOrderItem(orderItem);

        OrderItemResponseDto dto = new OrderItemResponseDto();
        dto.setId(savedItem.getId());
        dto.setOrderId(savedItem.getOrder().getId());
        dto.setCourseId(savedItem.getCourse().getId());
        dto.setPrice(savedItem.getPriceAtPurchase());

        ResponseStructure<OrderItemResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(201);
        structure.setMessage("Order Item Created Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<List<OrderItem>> getAllOrderItems() {

        ResponseStructure<List<OrderItem>> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("All Order Items Fetched Successfully");
        structure.setData(orderItemDao.getAllOrderItems());
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<OrderItem> findOrderItemById(Long id) {

        ResponseStructure<OrderItem> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Order Item Found Successfully");
        structure.setData(orderItemDao.findOrderItemById(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<OrderItemResponseDto> updateOrderItem(OrderItem orderItem) {

        OrderItem updatedItem = orderItemDao.updateOrderItem(orderItem);

        OrderItemResponseDto dto = new OrderItemResponseDto();
        dto.setId(updatedItem.getId());
        dto.setOrderId(updatedItem.getOrder().getId());
        dto.setCourseId(updatedItem.getCourse().getId());
        dto.setPrice(updatedItem.getPriceAtPurchase());

        ResponseStructure<OrderItemResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Order Item Updated Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<String> deleteOrderItem(Long id) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Order Item Deleted Successfully");
        structure.setData(orderItemDao.deleteOrderItem(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }
}