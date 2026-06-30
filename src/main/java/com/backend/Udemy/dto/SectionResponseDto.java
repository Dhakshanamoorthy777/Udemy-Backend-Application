// SectionResponseDto.java
package com.backend.Udemy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionResponseDto {

    private Long id;
    private String title;
    private Integer orderIndex;
}