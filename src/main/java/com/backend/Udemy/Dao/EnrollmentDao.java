package com.backend.Udemy.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.backend.Udemy.entity.Enrollment;
import com.backend.Udemy.repository.EnrollmentRepository;

@Repository
public class EnrollmentDao {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment findEnrollmentById(Long id) {
        Optional<Enrollment> optional = enrollmentRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("Enrollment Id Not Found");
        }
    }

    public Enrollment updateEnrollment(Enrollment enrollment) {
        Optional<Enrollment> optional = enrollmentRepository.findById(enrollment.getId());

        if (optional.isPresent()) {
            return enrollmentRepository.save(enrollment);
        } else {
            throw new IllegalArgumentException("Enrollment Id Not Found");
        }
    }

    public String deleteEnrollment(Long id) {
        Optional<Enrollment> optional = enrollmentRepository.findById(id);

        if (optional.isPresent()) {
            enrollmentRepository.deleteById(id);
            return "Enrollment Deleted Successfully";
        } else {
            throw new IllegalArgumentException("Enrollment Id Not Found");
        }
    }

    public Page<Enrollment> getEnrollmentsWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return enrollmentRepository.findAll(pageable);
    }
}