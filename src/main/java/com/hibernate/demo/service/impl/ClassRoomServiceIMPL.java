package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.ClassRoomDTO;
import com.hibernate.demo.mapper.ClassRoomMapper;
import com.hibernate.demo.model.ClassRoom;
import com.hibernate.demo.model.compositeIds.ClassRoomId;
import com.hibernate.demo.repository.ClassRoomRepository;
import com.hibernate.demo.service.ClassRoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassRoomServiceIMPL implements ClassRoomService {

    private final ClassRoomRepository classRoomRepository;
    private final ClassRoomMapper classRoomMapper;

    public ClassRoomServiceIMPL(ClassRoomRepository classRoomRepository, ClassRoomMapper classRoomMapper) {
        this.classRoomRepository = classRoomRepository;
        this.classRoomMapper = classRoomMapper;
    }

    @Override
    public ClassRoomDTO saveClassRoom(ClassRoomDTO classRoomDTO) {
        ClassRoom classRoom = classRoomMapper.toEntity(classRoomDTO);
        classRoom = classRoomRepository.save(classRoom);
        return classRoomMapper.toDTO(classRoom);
    }

    @Override
    public Optional<ClassRoomDTO> getClassRoomById(ClassRoomId id) {
        return classRoomRepository.findById(id).map(classRoomMapper::toDTO);
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms() {
        return classRoomRepository.findAll()
                .stream()
                .map(classRoomMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClassRoomDTO updateClassRoom(ClassRoomId id, ClassRoomDTO classRoomDTO) {
        Optional<ClassRoom> existingClassRoomOpt = classRoomRepository.findById(id);
        if (existingClassRoomOpt.isPresent()) {
            ClassRoom existingClassRoom = existingClassRoomOpt.get();
            ClassRoom updatedClassRoom = classRoomMapper.toEntity(classRoomDTO);
            updatedClassRoom.setBuilding(existingClassRoom.getBuilding());
            updatedClassRoom.setRoomNumber(existingClassRoom.getRoomNumber());
            updatedClassRoom = classRoomRepository.save(updatedClassRoom);
            return classRoomMapper.toDTO(updatedClassRoom);
        }
        return null;
    }

    @Override
    public boolean deleteClassRoom(ClassRoomId id) {
        if (classRoomRepository.existsById(id)) {
            classRoomRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
