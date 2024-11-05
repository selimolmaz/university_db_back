package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.InstructorDTO;
import com.hibernate.demo.model.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    @Mapping(source = "department.deptName", target = "deptName")
    InstructorDTO toDTO(Instructor instructor);

    @Mapping(target = "department.deptName", source = "deptName")
    Instructor toEntity(InstructorDTO instructorDTO);
}
