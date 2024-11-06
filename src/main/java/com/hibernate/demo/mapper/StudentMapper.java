package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.StudentDTO;
import com.hibernate.demo.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO dto);
}
