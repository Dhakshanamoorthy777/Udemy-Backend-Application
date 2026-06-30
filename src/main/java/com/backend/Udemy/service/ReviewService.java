package com.backend.Udemy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Udemy.Dao.ReviewDao;
import com.backend.Udemy.dto.ReviewResponseDto;
import com.backend.Udemy.entity.Review;
import com.backend.Udemy.util.ResponseStructure;

@Service
public class ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    public ResponseStructure<ReviewResponseDto> saveReview(Review review) {

        Review savedReview = reviewDao.saveReview(review);

        ReviewResponseDto dto = new ReviewResponseDto();
        dto.setId(savedReview.getId());
        dto.setUserId(savedReview.getUser().getId());
        dto.setCourseId(savedReview.getCourse().getId());
        dto.setRating(savedReview.getRating());
        dto.setComment(savedReview.getComment());

        ResponseStructure<ReviewResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(201);
        structure.setMessage("Review Added Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<List<Review>> getAllReviews() {

        ResponseStructure<List<Review>> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("All Reviews Fetched Successfully");
        structure.setData(reviewDao.getAllReviews());
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<Review> findReviewById(Long id) {

        ResponseStructure<Review> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Review Found Successfully");
        structure.setData(reviewDao.findReviewById(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<ReviewResponseDto> updateReview(Review review) {

        Review updatedReview = reviewDao.updateReview(review);

        ReviewResponseDto dto = new ReviewResponseDto();
        dto.setId(updatedReview.getId());
        dto.setUserId(updatedReview.getUser().getId());
        dto.setCourseId(updatedReview.getCourse().getId());
        dto.setRating(updatedReview.getRating());
        dto.setComment(updatedReview.getComment());

        ResponseStructure<ReviewResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Review Updated Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<String> deleteReview(Long id) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Review Deleted Successfully");
        structure.setData(reviewDao.deleteReview(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }
}