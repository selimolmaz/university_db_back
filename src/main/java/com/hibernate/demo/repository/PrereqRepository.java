package com.hibernate.demo.repository;

import com.hibernate.demo.model.Prereq;
import com.hibernate.demo.model.compositeIds.PrerequisiteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrereqRepository extends JpaRepository<Prereq, PrerequisiteId> {
    List<Prereq> findByCourseId(String courseId);
}
