package com.hibernate.demo.repository;

import com.hibernate.demo.model.TimeSlot;
import com.hibernate.demo.model.TimeSlotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository  extends JpaRepository<TimeSlot, TimeSlotId> {
}
