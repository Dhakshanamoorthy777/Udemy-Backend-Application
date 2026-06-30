package com.backend.Udemy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.backend.Udemy.Dao.CourseDao;
import com.backend.Udemy.dto.CourseResponseDto;
import com.backend.Udemy.entity.Course;
import com.backend.Udemy.util.ResponseStructure;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ModelMapper mapper;

    public ResponseStructure<CourseResponseDto> saveCourse(Course course) {

        Course savedCourse = courseDao.saveCourse(course);

        CourseResponseDto dto = mapper.map(savedCourse, CourseResponseDto.class);

        ResponseStructure<CourseResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(201);
        structure.setMessage("Course Created Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<List<Course>> getAllCourses() {

        ResponseStructure<List<Course>> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("All Courses Fetched Successfully");
        structure.setData(courseDao.getAllCourses());
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<Course> findCourseById(Long id) {

        ResponseStructure<Course> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Course Found Successfully");
        structure.setData(courseDao.findCourseById(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<CourseResponseDto> updateCourse(Course course) {

        Course updatedCourse = courseDao.updateCourse(course);

        CourseResponseDto dto = mapper.map(updatedCourse, CourseResponseDto.class);

        ResponseStructure<CourseResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Course Updated Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<String> deleteCourse(Long id) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Course Deleted Successfully");
        structure.setData(courseDao.deleteCourse(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }
    
    public ResponseStructure<Page<Course>> getCoursesWithPagination(int page, int size) {

        ResponseStructure<Page<Course>> structure = new ResponseStructure<>();

        structure.setStatusCode(200);
        structure.setMessage("Courses Fetched Successfully With Pagination");
        structure.setData(courseDao.getCoursesWithPagination(page, size));
        structure.setTimeStamp(java.time.LocalDateTime.now());

        return structure;
    }
    public ResponseStructure<List<Course>> searchCoursesByTitle(String title) {

        ResponseStructure<List<Course>> structure = new ResponseStructure<>();

        List<Course> courses = courseDao.searchCoursesByTitle(title);

        structure.setStatusCode(200);
        structure.setMessage("Courses Search Result");
        structure.setData(courses);
        structure.setTimeStamp(java.time.LocalDateTime.now());

        return structure;
    }
}