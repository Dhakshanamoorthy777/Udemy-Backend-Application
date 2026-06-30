package com.backend.Udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.Udemy.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}