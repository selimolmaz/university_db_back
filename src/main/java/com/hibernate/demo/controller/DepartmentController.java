package com.hibernate.demo.controller;

import com.hibernate.demo.dto.DepartmentDTO;
import com.hibernate.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uni/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{deptName}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable String deptName) {
        return departmentService.getDepartmentById(deptName)
                .map(departmentDTO -> new ResponseEntity<>(departmentDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PutMapping("/{deptName}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable String deptName, @RequestBody DepartmentDTO departmentDTO) {
        departmentDTO.setDeptName(deptName); // Güncellemeyi yapmadan önce deptName'i DTO'ya ayarlıyoruz
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(departmentDTO);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/{deptName}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String deptName) {
        departmentService.deleteDepartmentById(deptName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
