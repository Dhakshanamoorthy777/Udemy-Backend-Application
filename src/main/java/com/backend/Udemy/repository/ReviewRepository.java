package com.backend.Udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.Udemy.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}