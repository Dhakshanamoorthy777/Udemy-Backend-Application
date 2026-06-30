package com.backend.Udemy.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.backend.Udemy.entity.Lecture;
import com.backend.Udemy.repository.LectureRepository;

@Repository
public class LectureDao {

    @Autowired
    private LectureRepository lectureRepository;

    public Lecture saveLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Lecture findLectureById(Long id) {
        Optional<Lecture> optional = lectureRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("Lecture Id Not Found");
        }
    }

    public Lecture updateLecture(Lecture lecture) {
        Optional<Lecture> optional = lectureRepository.findById(lecture.getId());

        if (optional.isPresent()) {
            return lectureRepository.save(lecture);
        } else {
            throw new IllegalArgumentException("Lecture Id Not Found");
        }
    }

    public String deleteLecture(Long id) {
        Optional<Lecture> optional = lectureRepository.findById(id);

        if (optional.isPresent()) {
            lectureRepository.deleteById(id);
            return "Lecture Deleted Successfully";
        } else {
            throw new IllegalArgumentException("Lecture Id Not Found");
        }
    }

    public Page<Lecture> getLecturesWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return lectureRepository.findAll(pageable);
    }
}