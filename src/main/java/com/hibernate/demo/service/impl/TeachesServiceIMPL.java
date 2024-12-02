package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.SectionDTO;
import com.hibernate.demo.dto.TeachesDTO;
import com.hibernate.demo.mapper.SectionMapper;
import com.hibernate.demo.mapper.TeachesMapper;
import com.hibernate.demo.model.Section;
import com.hibernate.demo.model.Teaches;
import com.hibernate.demo.model.compositeIds.TeachesId;
import com.hibernate.demo.repository.TeachesRepository;
import com.hibernate.demo.service.TeachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeachesServiceIMPL implements TeachesService {

    private final TeachesRepository teachesRepository;
    private final TeachesMapper teachesMapper;
    private final SectionMapper sectionMapper;

    @Autowired
    public TeachesServiceIMPL(TeachesRepository teachesRepository, TeachesMapper teachesMapper, SectionMapper sectionMapper) {
        this.teachesRepository = teachesRepository;
        this.teachesMapper = teachesMapper;
        this.sectionMapper = sectionMapper;
    }

    @Override
    public Optional<TeachesDTO> getTeachesById(TeachesId id) {
       return teachesRepository.findById(id).map(teachesMapper::toDTO);
    }

    @Override
    public List<TeachesDTO> getAllTeaches() {
        List<Teaches> teachesList = teachesRepository.findAll();
        return teachesList.stream()
                .map(teachesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeachesDTO> getteachesByInstructorId(String instructorId) {
        return teachesRepository.findByInstructorId(instructorId)
                .stream()
                .map(teachesMapper::toDTO)
                .toList();
    }

    @Override
    public List<TeachesDTO> getTeachesByCourseId(String courseId) {
        return teachesRepository.findByCourseId(courseId)
                .stream()
                .map(teachesMapper::toDTO)
                .toList();
    }

    @Override
    public TeachesDTO saveTeaches(TeachesDTO teachesDTO) {
        Teaches teaches = teachesMapper.toEntity(teachesDTO);
        Teaches savedTeaches = teachesRepository.save(teaches);
        return teachesMapper.toDTO(savedTeaches);
    }

    @Override
    public boolean deleteTeaches(TeachesDTO teachesDTO) {
        TeachesId teachesId = new TeachesId(
                teachesDTO.getInstructorId(),
                teachesDTO.getCourseId(),
                teachesDTO.getSecId(),
                teachesDTO.getSemester(),
                teachesDTO.getYear()
        );
        if (!teachesRepository.existsById(teachesId)) {
            throw new RuntimeException("Teaches not found");
        }
        teachesRepository.deleteById(teachesId);
        return true;
    }

    @Override
    public Optional<TeachesDTO> getTeachesBySection(SectionDTO sectionDTO) {
        return teachesRepository.findBySection(sectionDTO.getCourseId(), sectionDTO.getSecId(), sectionDTO.getSemester(), sectionDTO.getYear())
                .map(teachesMapper::toDTO);
    }
}
