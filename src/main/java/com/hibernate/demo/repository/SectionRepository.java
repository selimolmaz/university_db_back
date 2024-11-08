package com.hibernate.demo.repository;

import com.hibernate.demo.model.Section;
import com.hibernate.demo.model.SectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, SectionId> {
}
