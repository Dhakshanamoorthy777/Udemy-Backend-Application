package com.backend.Udemy.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String category;
    private String level;
}