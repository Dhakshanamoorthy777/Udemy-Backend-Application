// SectionController.java
package com.backend.Udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.Udemy.dto.SectionResponseDto;
import com.backend.Udemy.entity.Section;
import com.backend.Udemy.service.SectionService;
import com.backend.Udemy.util.ResponseStructure;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping
    public ResponseStructure<SectionResponseDto> saveSection(@RequestBody Section section) {
        return sectionService.saveSection(section);
    }

    @GetMapping
    public ResponseStructure<?> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public ResponseStructure<?> findSectionById(@PathVariable Long id) {
        return sectionService.findSectionById(id);
    }

    @PutMapping
    public ResponseStructure<SectionResponseDto> updateSection(@RequestBody Section section) {
        return sectionService.updateSection(section);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteSection(@PathVariable Long id) {
        return sectionService.deleteSection(id);
    }
}