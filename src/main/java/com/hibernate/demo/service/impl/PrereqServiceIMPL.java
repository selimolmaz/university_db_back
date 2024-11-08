package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.PrereqDTO;
import com.hibernate.demo.mapper.PrereqMapper;
import com.hibernate.demo.model.Prereq;
import com.hibernate.demo.model.PrerequisiteId;
import com.hibernate.demo.repository.PrereqRepository;
import com.hibernate.demo.service.PrereqService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PrereqServiceIMPL implements PrereqService {

    private final PrereqRepository prereqRepository;
    private final PrereqMapper prereqMapper;

    public PrereqServiceIMPL(PrereqRepository prereqRepository, PrereqMapper prereqMapper) {
        this.prereqRepository = prereqRepository;
        this.prereqMapper = prereqMapper;
    }

    @Override
    public PrereqDTO savePrereq(PrereqDTO prereqDTO) {
        Prereq prereq = prereqMapper.toEntity(prereqDTO);
        Prereq savedPrereq = prereqRepository.save(prereq);
        return prereqMapper.toDTO(savedPrereq);
    }

    @Override
    public List<PrereqDTO> getPrereqByCourseId(String courseId) {
        return prereqRepository.findByCourseId(courseId)
                .stream()
                .map(prereqMapper::toDTO)
                .toList();
    }

    @Override
    public List<PrereqDTO> getAllPrereq() {
        return prereqRepository.findAll()
                .stream()
                .map(prereqMapper::toDTO)
                .toList();
    }

    @Override
    public void deletePrereqByCourseId(PrerequisiteId prerequisiteId) {
        prereqRepository.deleteById(prerequisiteId);
    }

    @Override
    public PrereqDTO updatePrereq(PrereqDTO existingPrereqDTO, PrereqDTO newPrereqDTO) {
        PrerequisiteId existingId = new PrerequisiteId(existingPrereqDTO.getCourseId(), existingPrereqDTO.getPrereqId());

        if (prereqRepository.existsById(existingId)) {
            prereqRepository.deleteById(existingId);
        } else {
            throw new RuntimeException("Prerequisite not found with ID: " + existingId);
        }

        Prereq newPrereq = prereqMapper.toEntity(newPrereqDTO);
        Prereq savedPrereq = prereqRepository.save(newPrereq);
        return prereqMapper.toDTO(savedPrereq);
    }



}
