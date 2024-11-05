package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.InstructorDTO;
import com.hibernate.demo.mapper.InstructorMapper;
import com.hibernate.demo.model.Instructor;
import com.hibernate.demo.repository.InstructorRepository;
import com.hibernate.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
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
    public List<InstructorDTO> getAllInstructors() {
        return instructorRepository.findAll().stream()
                .map(instructorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InstructorDTO updateInstructor(String id, InstructorDTO instructorDTO) {
        if (!instructorRepository.existsById(id)) {
            return null; // Eğer ID yoksa güncelleme yapılamaz
        }

        // Gelen DTO'dan yeni bir Instructor nesnesi oluşturulur
        Instructor instructor = instructorMapper.toEntity(instructorDTO);
        instructor.setId(id); // Mevcut ID atanır, böylece güncelleme yapılır

        // Güncellenmiş Instructor nesnesi kaydedilir
        Instructor updatedInstructor = instructorRepository.save(instructor);

        // Kaydedilen Instructor nesnesi DTO'ya dönüştürülür ve döndürülür
        return instructorMapper.toDTO(updatedInstructor);
    }

    @Override
    public boolean deleteInstructor(String id) {
        if (instructorRepository.existsById(id)) {
            instructorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
