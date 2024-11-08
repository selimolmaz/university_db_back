package com.hibernate.demo.repository;

import com.hibernate.demo.model.Teaches;
import com.hibernate.demo.model.TeachesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachesRepository extends JpaRepository<Teaches, TeachesId> {
}
