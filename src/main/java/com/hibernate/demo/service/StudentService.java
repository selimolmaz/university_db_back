package com.hibernate.demo.service;

import com.hibernate.demo.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);
    Optional<StudentDTO> getStudentById(String studentId);
    List<StudentDTO> getAllStudents();
    List<StudentDTO> getStudentsByDeptName(String deptName);
    void deleteStudentById(String studentId);
}
