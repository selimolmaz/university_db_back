package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.DepartmentDTO;
import com.hibernate.demo.mapper.DepartmentMapper;
import com.hibernate.demo.model.Department;
import com.hibernate.demo.repository.DepartmentRepository;
import com.hibernate.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceIMPL implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceIMPL(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDTO(savedDepartment);
    }

    @Override
    public Optional<DepartmentDTO> getDepartmentById(String deptName) {
        return departmentRepository.findById(deptName)
                .map(departmentMapper::toDTO);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toEntity(departmentDTO);
        Department updatedDepartment = departmentRepository.save(department);
        return departmentMapper.toDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartmentById(String deptName) {
        departmentRepository.deleteById(deptName);
    }
}
