package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.DepartmentDTO;
import com.hibernate.demo.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDTO toDTO(Department department);

    Department toEntity(DepartmentDTO dto);
}
