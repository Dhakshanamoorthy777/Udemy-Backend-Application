package com.backend.Udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.Udemy.entity.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}