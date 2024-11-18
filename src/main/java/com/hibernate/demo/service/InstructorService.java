package com.hibernate.demo.service;

import com.hibernate.demo.dto.InstructorDTO;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    InstructorDTO saveInstructor(InstructorDTO instructorDTO);
    Optional<InstructorDTO> getInstructorById(String id);
    List<InstructorDTO> getAllInstructor();
    List<InstructorDTO> getInstructorsByDeptName(String department);
    void deleteInstructorById(String id);
}
