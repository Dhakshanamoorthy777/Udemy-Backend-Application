package com.backend.Udemy.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.backend.Udemy.entity.Review;
import com.backend.Udemy.repository.ReviewRepository;

@Repository
public class ReviewDao {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review findReviewById(Long id) {
        Optional<Review> optional = reviewRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("Review Id Not Found");
        }
    }

    public Review updateReview(Review review) {
        Optional<Review> optional = reviewRepository.findById(review.getId());

        if (optional.isPresent()) {
            return reviewRepository.save(review);
        } else {
            throw new IllegalArgumentException("Review Id Not Found");
        }
    }

    public String deleteReview(Long id) {
        Optional<Review> optional = reviewRepository.findById(id);

        if (optional.isPresent()) {
            reviewRepository.deleteById(id);
            return "Review Deleted Successfully";
        } else {
            throw new IllegalArgumentException("Review Id Not Found");
        }
    }

    public Page<Review> getReviewsWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return reviewRepository.findAll(pageable);
    }
}