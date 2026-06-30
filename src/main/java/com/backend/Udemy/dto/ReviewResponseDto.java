package com.backend.Udemy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {

    private Long id;
    private Long userId;
    private Long courseId;
    private Integer rating;
    private String comment;
}