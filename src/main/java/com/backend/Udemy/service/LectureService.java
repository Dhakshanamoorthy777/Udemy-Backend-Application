// LectureService.java
package com.backend.Udemy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Udemy.Dao.LectureDao;
import com.backend.Udemy.dto.LectureResponseDto;
import com.backend.Udemy.entity.Lecture;
import com.backend.Udemy.util.ResponseStructure;

@Service
public class LectureService {

    @Autowired
    private LectureDao lectureDao;

    @Autowired
    private ModelMapper mapper;

    public ResponseStructure<LectureResponseDto> saveLecture(Lecture lecture) {

        Lecture savedLecture = lectureDao.saveLecture(lecture);

        LectureResponseDto dto = mapper.map(savedLecture, LectureResponseDto.class);
        dto.setContentType(savedLecture.getContentType().name());

        ResponseStructure<LectureResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(201);
        structure.setMessage("Lecture Created Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<List<Lecture>> getAllLectures() {

        ResponseStructure<List<Lecture>> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("All Lectures Fetched Successfully");
        structure.setData(lectureDao.getAllLectures());
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<Lecture> findLectureById(Long id) {

        ResponseStructure<Lecture> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Lecture Found Successfully");
        structure.setData(lectureDao.findLectureById(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<LectureResponseDto> updateLecture(Lecture lecture) {

        Lecture updatedLecture = lectureDao.updateLecture(lecture);

        LectureResponseDto dto = mapper.map(updatedLecture, LectureResponseDto.class);
        dto.setContentType(updatedLecture.getContentType().name());

        ResponseStructure<LectureResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Lecture Updated Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<String> deleteLecture(Long id) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Lecture Deleted Successfully");
        structure.setData(lectureDao.deleteLecture(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }
}