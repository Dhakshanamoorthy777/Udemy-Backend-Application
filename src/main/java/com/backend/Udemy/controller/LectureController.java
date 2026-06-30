// LectureController.java
package com.backend.Udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.Udemy.dto.LectureResponseDto;
import com.backend.Udemy.entity.Lecture;
import com.backend.Udemy.service.LectureService;
import com.backend.Udemy.util.ResponseStructure;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @PostMapping
    public ResponseStructure<LectureResponseDto> saveLecture(@RequestBody Lecture lecture) {
        return lectureService.saveLecture(lecture);
    }

    @GetMapping
    public ResponseStructure<?> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @GetMapping("/{id}")
    public ResponseStructure<?> findLectureById(@PathVariable Long id) {
        return lectureService.findLectureById(id);
    }

    @PutMapping
    public ResponseStructure<LectureResponseDto> updateLecture(@RequestBody Lecture lecture) {
        return lectureService.updateLecture(lecture);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteLecture(@PathVariable Long id) {
        return lectureService.deleteLecture(id);
    }
}