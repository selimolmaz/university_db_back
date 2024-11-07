package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.InstructorDTO;
import com.hibernate.demo.model.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorDTO toDTO(Instructor instructor);
    Instructor toEntity(InstructorDTO instructorDTO);
}
