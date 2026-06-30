package com.backend.Udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.Udemy.dto.ReviewResponseDto;
import com.backend.Udemy.entity.Review;
import com.backend.Udemy.service.ReviewService;
import com.backend.Udemy.util.ResponseStructure;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseStructure<ReviewResponseDto> saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @GetMapping
    public ResponseStructure<?> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseStructure<?> findReviewById(@PathVariable Long id) {
        return reviewService.findReviewById(id);
    }

    @PutMapping
    public ResponseStructure<ReviewResponseDto> updateReview(@RequestBody Review review) {
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteReview(@PathVariable Long id) {
        return reviewService.deleteReview(id);
    }
}