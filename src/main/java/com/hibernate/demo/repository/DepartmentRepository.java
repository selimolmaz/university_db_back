package com.hibernate.demo.repository;

import com.hibernate.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findByBuilding(String building);
}
