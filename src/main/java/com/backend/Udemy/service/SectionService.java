// SectionService.java
package com.backend.Udemy.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Udemy.Dao.SectionDao;
import com.backend.Udemy.dto.SectionResponseDto;
import com.backend.Udemy.entity.Section;
import com.backend.Udemy.util.ResponseStructure;

@Service
public class SectionService {

    @Autowired
    private SectionDao sectionDao;

    @Autowired
    private ModelMapper mapper;

    public ResponseStructure<SectionResponseDto> saveSection(Section section) {

        Section savedSection = sectionDao.saveSection(section);

        SectionResponseDto dto = mapper.map(savedSection, SectionResponseDto.class);

        ResponseStructure<SectionResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(201);
        structure.setMessage("Section Created Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<List<Section>> getAllSections() {

        ResponseStructure<List<Section>> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("All Sections Fetched Successfully");
        structure.setData(sectionDao.getAllSections());
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<Section> findSectionById(Long id) {

        ResponseStructure<Section> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Section Found Successfully");
        structure.setData(sectionDao.findSectionById(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<SectionResponseDto> updateSection(Section section) {

        Section updatedSection = sectionDao.updateSection(section);

        SectionResponseDto dto = mapper.map(updatedSection, SectionResponseDto.class);

        ResponseStructure<SectionResponseDto> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Section Updated Successfully");
        structure.setData(dto);
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }

    public ResponseStructure<String> deleteSection(Long id) {

        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(200);
        structure.setMessage("Section Deleted Successfully");
        structure.setData(sectionDao.deleteSection(id));
        structure.setTimeStamp(LocalDateTime.now());

        return structure;
    }
}