package com.backend.Udemy.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.backend.Udemy.entity.Section;
import com.backend.Udemy.repository.SectionRepository;

@Repository
public class SectionDao {

    @Autowired
    private SectionRepository sectionRepository;

    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section findSectionById(Long id) {
        Optional<Section> optional = sectionRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("Section Id Not Found");
        }
    }

    public Section updateSection(Section section) {
        Optional<Section> optional = sectionRepository.findById(section.getId());

        if (optional.isPresent()) {
            return sectionRepository.save(section);
        } else {
            throw new IllegalArgumentException("Section Id Not Found");
        }
    }

    public String deleteSection(Long id) {
        Optional<Section> optional = sectionRepository.findById(id);

        if (optional.isPresent()) {
            sectionRepository.deleteById(id);
            return "Section Deleted Successfully";
        } else {
            throw new IllegalArgumentException("Section Id Not Found");
        }
    }

    public Page<Section> getSectionsWithPagination(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return sectionRepository.findAll(pageable);
    }

    public Section saveUpdatedSection(Section section) {
        return sectionRepository.save(section);
    }
}