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

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(studentMapper::studentToStudentDTO)
                .toList(); // Java 16 ve sonrası için
    }

    @Override
    public StudentDTO getStudentById(String id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(studentMapper::studentToStudentDTO).orElse(null);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.studentDTOToStudent(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.studentToStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(String id, StudentDTO studentDTO) {
        if (!studentRepository.existsById(id)) {
            return null;
        }
        Student student = studentMapper.studentDTOToStudent(studentDTO);
        student.setId(id); // ID'yi ayarlıyoruz, böylece güncelleme gerçekleşiyor
        Student updatedStudent = studentRepository.save(student);
        return studentMapper.studentToStudentDTO(updatedStudent);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
