package com.hibernate.demo.repository;

import com.hibernate.demo.model.Section;
import com.hibernate.demo.model.compositeIds.SectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, SectionId> {
}
