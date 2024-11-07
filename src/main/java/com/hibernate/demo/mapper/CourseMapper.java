package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.CourseDTO;
import com.hibernate.demo.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDTO(Course course);
    Course toEntity(CourseDTO courseDTO);
}
