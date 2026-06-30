// EnrollmentController.java
package com.backend.Udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.Udemy.dto.EnrollmentResponseDto;
import com.backend.Udemy.entity.Enrollment;
import com.backend.Udemy.service.EnrollmentService;
import com.backend.Udemy.util.ResponseStructure;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseStructure<EnrollmentResponseDto> saveEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.saveEnrollment(enrollment);
    }

    @GetMapping
    public ResponseStructure<?> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public ResponseStructure<?> findEnrollmentById(@PathVariable Long id) {
        return enrollmentService.findEnrollmentById(id);
    }

    @PutMapping
    public ResponseStructure<EnrollmentResponseDto> updateEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(enrollment);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteEnrollment(@PathVariable Long id) {
        return enrollmentService.deleteEnrollment(id);
    }
}