// EnrollmentService.java
package com.backend.Udemy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Udemy.Dao.EnrollmentDao;
import com.backend.Udemy.dto.EnrollmentResponseDto;
import com.backend.Udemy.entity.Enrollment;
import com.backend.Udemy.util.ResponseStructure;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;

    @Autowired
    private ModelMapper mapper;

    public ResponseStructure<EnrollmentResponseDto> saveEnrollment(Enrollment enrollment) {

        Enrollment savedEnrollment = enrollmentDao.saveEnrollment(enrollment);

        EnrollmentResponseDto dto = new EnrollmentResponseDto();
        dto.setId(savedEnrollment.getId());
        dto.setUserId(savedEnrollment.getStudent().getId());
        dto.setCourseId(savedEnrollment.getCourse().getId());
        dto.setEnrolledAt(savedEnrollment.getEnrolledAt());

        ResponseStructure<EnrollmentResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(201);
        structure.setMessage("Enrollment Created Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<List<Enrollment>> getAllEnrollments() {

        ResponseStructure<List<Enrollment>> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("All Enrollments Fetched Successfully");
        structure.setData(enrollmentDao.getAllEnrollments());
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<Enrollment> findEnrollmentById(Long id) {

        ResponseStructure<Enrollment> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Enrollment Found Successfully");
        structure.setData(enrollmentDao.findEnrollmentById(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<EnrollmentResponseDto> updateEnrollment(Enrollment enrollment) {

        Enrollment updatedEnrollment = enrollmentDao.updateEnrollment(enrollment);

        EnrollmentResponseDto dto = new EnrollmentResponseDto();
        dto.setId(updatedEnrollment.getId());
        dto.setUserId(updatedEnrollment.getStudent().getId());
        dto.setCourseId(updatedEnrollment.getCourse().getId());
        dto.setEnrolledAt(updatedEnrollment.getEnrolledAt());

        ResponseStructure<EnrollmentResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Enrollment Updated Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<String> deleteEnrollment(Long id) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Enrollment Deleted Successfully");
        structure.setData(enrollmentDao.deleteEnrollment(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }
}