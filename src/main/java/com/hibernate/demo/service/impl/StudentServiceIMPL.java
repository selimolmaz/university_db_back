package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.StudentDTO;
import com.hibernate.demo.mapper.StudentMapper;
import com.hibernate.demo.model.Student;
import com.hibernate.demo.repository.StudentRepository;
import com.hibernate.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceIMPL implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceIMPL(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDTO(savedStudent);
    }

    @Override
    public Optional<StudentDTO> getStudentById(String studentId) {
        return  studentRepository.findById(studentId)
                .map(studentMapper::toDTO);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByDeptName(String deptName) {
        return studentRepository.findByDeptName(deptName)
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudentById(String studentId) {
        studentRepository.deleteById(studentId);
    }
}
