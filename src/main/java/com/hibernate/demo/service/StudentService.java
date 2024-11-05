package com.hibernate.demo.service;

import com.hibernate.demo.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(String id);
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(String id, StudentDTO studentDTO);
    void deleteStudent(String id);
}
