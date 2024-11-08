package com.hibernate.demo.repository;

import com.hibernate.demo.model.Takes;
import com.hibernate.demo.model.TakesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakesRepository extends JpaRepository<Takes, TakesId> {
}
