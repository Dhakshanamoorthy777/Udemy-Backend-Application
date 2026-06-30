// EnrollmentResponseDto.java
package com.backend.Udemy.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponseDto {

    private Long id;
    private Long userId;
    private Long courseId;
    private LocalDateTime enrolledAt;
}