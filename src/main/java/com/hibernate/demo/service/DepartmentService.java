package com.hibernate.demo.service;

import com.hibernate.demo.dto.DepartmentDTO;
import com.hibernate.demo.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    Optional<DepartmentDTO> getDepartmentById(String deptName);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDepartment(DepartmentDTO departmentDTO);

    void deleteDepartmentById(String deptName);
}