package com.backend.Udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.Udemy.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}