package com.hibernate.demo.service;

import com.hibernate.demo.dto.InstructorDTO;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    InstructorDTO saveInstructor(InstructorDTO instructorDTO);
    Optional<InstructorDTO> getInstructorById(String id);
    List<InstructorDTO> getAllInstructors();
    InstructorDTO updateInstructor(String id, InstructorDTO instructorDTO);
    boolean deleteInstructor(String id);
}
