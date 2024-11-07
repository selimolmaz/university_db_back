package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.InstructorDTO;
import com.hibernate.demo.mapper.InstructorMapper;
import com.hibernate.demo.model.Instructor;
import com.hibernate.demo.repository.InstructorRepository;
import com.hibernate.demo.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceIMPL implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorServiceIMPL(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    @Override
    public InstructorDTO saveInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = instructorMapper.toEntity(instructorDTO);
        Instructor savedInstructor = instructorRepository.save(instructor);
        return instructorMapper.toDTO(savedInstructor);
    }

    @Override
    public Optional<InstructorDTO> getInstructorById(String id) {
        return instructorRepository.findById(id)
                .map(instructorMapper::toDTO);
    }

    @Override
    public List<InstructorDTO> getAllInstructor() {
        return instructorRepository.findAll()
                .stream()
                .map(instructorMapper::toDTO)
                .toList();
    }

    @Override
    public void deleteInstructorById(String id) {
        instructorRepository.deleteById(id);
    }
}
