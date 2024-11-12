package com.hibernate.demo.service;

import com.hibernate.demo.dto.TimeSlotDTO;
import com.hibernate.demo.model.compositeIds.TimeSlotId;

import java.util.List;
import java.util.Optional;

public interface TimeSlotService {
    TimeSlotDTO saveTimeSlot(TimeSlotDTO timeSlotDTO);
    Optional<TimeSlotDTO> getTimeSlotById(TimeSlotId id);
    List<TimeSlotDTO> getAllTimeSlots();
    TimeSlotDTO updateTimeSlot(TimeSlotId id, TimeSlotDTO timeSlotDTO);
    boolean deleteTimeSlot(TimeSlotId id);
}
