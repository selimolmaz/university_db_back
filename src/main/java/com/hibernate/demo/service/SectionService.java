package com.hibernate.demo.service;

import com.hibernate.demo.dto.SectionDTO;

import java.util.List;

public interface SectionService {

    SectionDTO getSection(String courseId, String secId, String semester, int year);

    List<SectionDTO> getAllSections();

    SectionDTO createSection(SectionDTO sectionDTO);

    SectionDTO updateSection(String courseId, String secId, String semester, int year, SectionDTO sectionDTO);

    boolean deleteSection(String courseId, String secId, String semester, int year);
}
