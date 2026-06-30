package com.backend.Udemy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureResponseDto {

    private Long id;
    private String title;
    private String contentType;
    private String contentUrl;
    private Integer orderIndex;
}