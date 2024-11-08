package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.TimeSlotDTO;
import com.hibernate.demo.model.TimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    TimeSlotDTO toDTO(TimeSlot timeSlot);
    TimeSlot toEntity(TimeSlotDTO timeSlotDTO);
}
