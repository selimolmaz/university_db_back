package com.hibernate.demo.repository;

import com.hibernate.demo.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String> {
    List<Instructor> findByDeptName(String deptName);
}
