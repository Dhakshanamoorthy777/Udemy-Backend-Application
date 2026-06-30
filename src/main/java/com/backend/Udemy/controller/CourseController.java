package com.backend.Udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.backend.Udemy.dto.CourseResponseDto;
import com.backend.Udemy.entity.Course;
import com.backend.Udemy.service.CourseService;
import com.backend.Udemy.util.ResponseStructure;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseStructure<CourseResponseDto> saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping
    public ResponseStructure<?> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseStructure<?> findCourseById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    @PutMapping
    public ResponseStructure<CourseResponseDto> updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
    @GetMapping("/page")
    public ResponseStructure<Page<Course>> getCoursesWithPagination(
            @RequestParam int page,
            @RequestParam int size) {

        return courseService.getCoursesWithPagination(page, size);
    }
    
    @GetMapping("/search")
    public ResponseStructure<List<Course>> searchCoursesByTitle(
            @RequestParam String title) {

        return courseService.searchCoursesByTitle(title);
    }
}