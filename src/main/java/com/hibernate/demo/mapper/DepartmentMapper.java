package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.DepartmentDTO;
import com.hibernate.demo.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentDTO toDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDeptName(department.getDeptName());
        dto.setBuilding(department.getBuilding());
        dto.setBudget(department.getBudget());
        return dto;
    }

    public Department toEntity(DepartmentDTO dto) {
        Department department = new Department();
        department.setDeptName(dto.getDeptName());
        department.setBuilding(dto.getBuilding());
        department.setBudget(dto.getBudget());
        return department;
    }
}
