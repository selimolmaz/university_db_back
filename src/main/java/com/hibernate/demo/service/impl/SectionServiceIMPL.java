package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.SectionDTO;
import com.hibernate.demo.mapper.SectionMapper;
import com.hibernate.demo.model.Section;
import com.hibernate.demo.model.SectionId;
import com.hibernate.demo.repository.SectionRepository;
import com.hibernate.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SectionServiceIMPL implements SectionService {

    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;

    @Autowired
    public SectionServiceIMPL(SectionRepository sectionRepository, SectionMapper sectionMapper) {
        this.sectionRepository = sectionRepository;
        this.sectionMapper = sectionMapper;
    }

    @Override
    public SectionDTO getSection(String courseId, String secId, String semester, int year) {
        Optional<Section> section = sectionRepository.findById(new SectionId(courseId, secId, semester, year));
        return section.map(sectionMapper::toDTO).orElse(null);
    }

    @Override
    public List<SectionDTO> getAllSections() {
        return sectionRepository.findAll()
                .stream()
                .map(sectionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SectionDTO createSection(SectionDTO sectionDTO) {
        Section section = sectionMapper.toEntity(sectionDTO);
        section = sectionRepository.save(section);
        return sectionMapper.toDTO(section);
    }

    @Override
    public SectionDTO updateSection(String courseId, String secId, String semester, int year, SectionDTO sectionDTO) {
        Optional<Section> existingSection = sectionRepository.findById(new SectionId(courseId, secId, semester, year));
        if (existingSection.isPresent()) {
            Section section = sectionMapper.toEntity(sectionDTO);
            section.setCourseId(courseId);
            section.setSecId(secId);
            section.setSemester(semester);
            section.setYear(year);
            section = sectionRepository.save(section);
            return sectionMapper.toDTO(section);
        }
        return null;
    }

    @Override
    public boolean deleteSection(String courseId, String secId, String semester, int year) {
        Optional<Section> section = sectionRepository.findById(new SectionId(courseId, secId, semester, year));
        if (section.isPresent()) {
            sectionRepository.delete(section.get());
            return true;
        }
        return false;
    }
}
