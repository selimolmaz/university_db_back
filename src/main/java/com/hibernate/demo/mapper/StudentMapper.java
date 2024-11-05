package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.StudentDTO;
import com.hibernate.demo.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "department.deptName", target = "deptName") // Department'dan deptName alanını al
    StudentDTO studentToStudentDTO(Student student);

    @Mapping(source = "deptName", target = "department.deptName") // DTO'dan deptName alanını al
    Student studentDTOToStudent(StudentDTO studentDTO);
}
