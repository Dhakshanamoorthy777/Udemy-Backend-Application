// OrderItemResponseDto.java
package com.backend.Udemy.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDto {

    private Long id;
    private Long orderId;
    private Long courseId;
    private BigDecimal price;
}