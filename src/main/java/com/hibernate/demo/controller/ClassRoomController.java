package com.hibernate.demo.controller;

import com.hibernate.demo.dto.ClassRoomDTO;
import com.hibernate.demo.model.compositeIds.ClassRoomId;
import com.hibernate.demo.service.ClassRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uni/classrooms")
public class ClassRoomController {

    private final ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @PostMapping
    public ResponseEntity<ClassRoomDTO> createClassRoom(@RequestBody ClassRoomDTO classRoomDTO) {
        ClassRoomDTO createdClassRoom = classRoomService.saveClassRoom(classRoomDTO);
        return new ResponseEntity<>(createdClassRoom, HttpStatus.CREATED);
    }

    @PutMapping("/{building}/{roomNumber}")
    public ResponseEntity<ClassRoomDTO> updateClassRoom(@PathVariable String building,
                                                        @PathVariable String roomNumber,
                                                        @RequestBody ClassRoomDTO classRoomDTO) {
        ClassRoomId id = new ClassRoomId(building, roomNumber);
        ClassRoomDTO updatedClassRoom = classRoomService.updateClassRoom(id, classRoomDTO);
        return updatedClassRoom != null ? ResponseEntity.ok(updatedClassRoom) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{building}/{roomNumber}")
    public ResponseEntity<ClassRoomDTO> getClassRoomById(@PathVariable String building, @PathVariable String roomNumber) {
        ClassRoomId id = new ClassRoomId(building, roomNumber);
        Optional<ClassRoomDTO> classRoomDTO = classRoomService.getClassRoomById(id);
        return classRoomDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ClassRoomDTO>> getAllClassRooms() {
        List<ClassRoomDTO> classRooms = classRoomService.getAllClassRooms();
        return ResponseEntity.ok(classRooms);
    }

    @DeleteMapping("/{building}/{roomNumber}")
    public ResponseEntity<Void> deleteClassRoom(@PathVariable String building, @PathVariable String roomNumber) {
        ClassRoomId id = new ClassRoomId(building, roomNumber);
        boolean isDeleted = classRoomService.deleteClassRoom(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
