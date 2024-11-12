package com.hibernate.demo.repository;

import com.hibernate.demo.model.Takes;
import com.hibernate.demo.model.compositeIds.TakesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TakesRepository extends JpaRepository<Takes, TakesId> {
    List<Takes> findByStudentId(String studentId);
}
