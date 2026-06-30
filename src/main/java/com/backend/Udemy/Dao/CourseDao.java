package com.backend.Udemy.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.backend.Udemy.entity.Course;
import com.backend.Udemy.repository.CourseRepository;

@Repository
public class CourseDao {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course findCourseById(Long id) {
        Optional<Course> optional = courseRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("Course Id Not Found");
        }
    }

    public Course updateCourse(Course course) {
        Optional<Course> optional = courseRepository.findById(course.getId());

        if (optional.isPresent()) {
            return courseRepository.save(course);
        } else {
            throw new IllegalArgumentException("Course Id Not Found");
        }
    }

    public String deleteCourse(Long id) {
        Optional<Course> optional = courseRepository.findById(id);

        if (optional.isPresent()) {
            courseRepository.deleteById(id);
            return "Course Deleted Successfully";
        } else {
            throw new IllegalArgumentException("Course Id Not Found");
        }
    }

    public Page<Course> getCoursesWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return courseRepository.findAll(pageable);
    }
    public List<Course> searchCoursesByTitle(String title) {
        return courseRepository.findByTitleContainingIgnoreCase(title);
    }
    
}