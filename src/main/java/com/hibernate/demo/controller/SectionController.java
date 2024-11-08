package com.hibernate.demo.controller;

import com.hibernate.demo.dto.SectionDTO;
import com.hibernate.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uni/sections")
public class SectionController {

    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    // Get a specific section by ID (courseId, secId, semester, year)
    @GetMapping("/{courseId}/{secId}/{semester}/{year}")
    public ResponseEntity<SectionDTO> getSection(@PathVariable String courseId,
                                                 @PathVariable String secId,
                                                 @PathVariable String semester,
                                                 @PathVariable int year) {
        SectionDTO sectionDTO = sectionService.getSection(courseId, secId, semester, year);
        if (sectionDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sectionDTO);
    }

    // Get all sections
    @GetMapping
    public ResponseEntity<List<SectionDTO>> getAllSections() {
        List<SectionDTO> sections = sectionService.getAllSections();
        return ResponseEntity.ok(sections);
    }

    // Create a new section
    @PostMapping
    public ResponseEntity<SectionDTO> createSection(@RequestBody SectionDTO sectionDTO) {
        SectionDTO createdSection = sectionService.createSection(sectionDTO);
        return ResponseEntity.status(201).body(createdSection);
    }

    // Update an existing section
    @PutMapping("/{courseId}/{secId}/{semester}/{year}")
    public ResponseEntity<SectionDTO> updateSection(@PathVariable String courseId,
                                                    @PathVariable String secId,
                                                    @PathVariable String semester,
                                                    @PathVariable int year,
                                                    @RequestBody SectionDTO sectionDTO) {
        SectionDTO updatedSection = sectionService.updateSection(courseId, secId, semester, year, sectionDTO);
        if (updatedSection == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSection);
    }

    // Delete a section
    @DeleteMapping("/{courseId}/{secId}/{semester}/{year}")
    public ResponseEntity<Void> deleteSection(@PathVariable String courseId,
                                              @PathVariable String secId,
                                              @PathVariable String semester,
                                              @PathVariable int year) {
        boolean isDeleted = sectionService.deleteSection(courseId, secId, semester, year);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
