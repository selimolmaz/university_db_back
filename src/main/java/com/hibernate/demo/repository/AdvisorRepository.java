package com.hibernate.demo.repository;

import com.hibernate.demo.model.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, String> {
    List<Advisor> findByIid(String iId);
}