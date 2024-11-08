package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.ClassRoomDTO;
import com.hibernate.demo.model.ClassRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassRoomMapper {
    ClassRoomDTO toDTO(ClassRoom classRoom);
    ClassRoom toEntity(ClassRoomDTO classRoomDTO);
}
