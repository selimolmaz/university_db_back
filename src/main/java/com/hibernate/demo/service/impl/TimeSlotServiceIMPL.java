package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.TimeSlotDTO;
import com.hibernate.demo.mapper.TimeSlotMapper;
import com.hibernate.demo.model.TimeSlot;
import com.hibernate.demo.model.compositeIds.TimeSlotId;
import com.hibernate.demo.repository.TimeSlotRepository;
import com.hibernate.demo.service.TimeSlotService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotServiceIMPL implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final TimeSlotMapper timeSlotMapper;

    public TimeSlotServiceIMPL(TimeSlotRepository timeSlotRepository, TimeSlotMapper timeSlotMapper) {
        this.timeSlotRepository = timeSlotRepository;
        this.timeSlotMapper = timeSlotMapper;
    }

    @Override
    public TimeSlotDTO saveTimeSlot(TimeSlotDTO timeSlotDTO) {
        TimeSlot timeSlot = timeSlotMapper.toEntity(timeSlotDTO);
        timeSlot = timeSlotRepository.save(timeSlot);
        return timeSlotMapper.toDTO(timeSlot);
    }

    @Override
    public Optional<TimeSlotDTO> getTimeSlotById(TimeSlotId id) {
        return timeSlotRepository.findById(id).map(timeSlotMapper::toDTO);
    }

    @Override
    public List<TimeSlotDTO> getAllTimeSlots() {
        return timeSlotRepository.findAll()
                .stream()
                .map(timeSlotMapper::toDTO)
                .toList();
    }

    @Override
    public TimeSlotDTO updateTimeSlot(TimeSlotId id, TimeSlotDTO timeSlotDTO) {
        Optional<TimeSlot> existingTimeSlotOpt = timeSlotRepository.findById(id);
        if (existingTimeSlotOpt.isPresent()) {
            TimeSlot existingTimeSlot = existingTimeSlotOpt.get();
            TimeSlot updatedTimeSlot = timeSlotMapper.toEntity(timeSlotDTO);
            updatedTimeSlot.setTimeSlotId(existingTimeSlot.getTimeSlotId());
            updatedTimeSlot.setDay(existingTimeSlot.getDay());
            updatedTimeSlot.setStartHr(existingTimeSlot.getStartHr());
            updatedTimeSlot.setStartMin(existingTimeSlot.getStartMin());
            updatedTimeSlot = timeSlotRepository.save(updatedTimeSlot);
            return timeSlotMapper.toDTO(updatedTimeSlot);
        }
        return null;
    }

    @Override
    public boolean deleteTimeSlot(TimeSlotId id) {
        if (timeSlotRepository.existsById(id)) {
            timeSlotRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
