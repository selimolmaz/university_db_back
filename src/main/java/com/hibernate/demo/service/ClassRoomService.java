package com.hibernate.demo.service;

import com.hibernate.demo.dto.ClassRoomDTO;
import com.hibernate.demo.model.ClassRoomId;

import java.util.List;
import java.util.Optional;

public interface ClassRoomService {
    ClassRoomDTO saveClassRoom(ClassRoomDTO classRoomDTO);
    Optional<ClassRoomDTO> getClassRoomById(ClassRoomId id);
    List<ClassRoomDTO> getAllClassRooms();
    ClassRoomDTO updateClassRoom(ClassRoomId id, ClassRoomDTO classRoomDTO);
    boolean deleteClassRoom(ClassRoomId id);
}
