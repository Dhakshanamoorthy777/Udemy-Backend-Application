package com.backend.Udemy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.Udemy.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

List<Course> findByTitleContainingIgnoreCase(String title);
}