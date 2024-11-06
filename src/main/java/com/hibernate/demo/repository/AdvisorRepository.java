package com.hibernate.demo.repository;

import com.hibernate.demo.model.Advisor;
import com.hibernate.demo.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, String> {


    Advisor findBySid(String sId);
    List<Advisor> findByIid(String iId);
}