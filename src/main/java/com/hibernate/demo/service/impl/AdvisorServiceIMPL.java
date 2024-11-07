package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.AdvisorDTO;
import com.hibernate.demo.mapper.AdvisorMapper;
import com.hibernate.demo.model.Advisor;
import com.hibernate.demo.repository.AdvisorRepository;
import com.hibernate.demo.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvisorServiceIMPL implements AdvisorService {

    private final AdvisorRepository advisorRepository;
    private final AdvisorMapper advisorMapper;

    @Autowired
    public AdvisorServiceIMPL(AdvisorRepository advisorRepository, AdvisorMapper advisorMapper) {
        this.advisorRepository = advisorRepository;
        this.advisorMapper = advisorMapper;
    }

    @Override
    public AdvisorDTO saveAdvisor(AdvisorDTO advisorDTO) {
        Advisor advisor = advisorMapper.toEntity(advisorDTO);
        Advisor savedAdvisor = advisorRepository.save(advisor);
        return advisorMapper.toDTO(savedAdvisor);
    }

    @Override
    public Optional<AdvisorDTO> getAdvisorById(String studentId) {
        return advisorRepository.findById(studentId)
                .map(advisorMapper::toDTO);
    }

    @Override
    public List<AdvisorDTO> getAllAdvisors() {
        return advisorRepository.findAll()
                .stream()
                .map(advisorMapper::toDTO)
                .toList();
    }

    @Override
    public void deleteAdvisorById(String studentId) {
        advisorRepository.deleteById(studentId);
    }
}
