package com.hibernate.demo.controller;

import com.hibernate.demo.dto.TimeSlotDTO;
import com.hibernate.demo.model.TimeSlotId;
import com.hibernate.demo.service.TimeSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uni/time-slots")
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @PostMapping
    public ResponseEntity<TimeSlotDTO> createTimeSlot(@RequestBody TimeSlotDTO timeSlotDTO) {
        TimeSlotDTO savedTimeSlot = timeSlotService.saveTimeSlot(timeSlotDTO);
        return new ResponseEntity<>(savedTimeSlot, HttpStatus.CREATED);
    }

    @PutMapping("/{timeSlotId}/{day}/{startHr}/{startMin}")
    public ResponseEntity<TimeSlotDTO> updateTimeSlot(
            @PathVariable String timeSlotId,
            @PathVariable String day,
            @PathVariable int startHr,
            @PathVariable int startMin,
            @RequestBody TimeSlotDTO timeSlotDTO) {

        TimeSlotId id = new TimeSlotId(timeSlotId, day, startHr, startMin);
        TimeSlotDTO updatedTimeSlot = timeSlotService.updateTimeSlot(id, timeSlotDTO);

        return updatedTimeSlot != null
                ? ResponseEntity.ok(updatedTimeSlot)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{timeSlotId}/{day}/{startHr}/{startMin}")
    public ResponseEntity<TimeSlotDTO> getTimeSlotById(
            @PathVariable String timeSlotId,
            @PathVariable String day,
            @PathVariable int startHr,
            @PathVariable int startMin) {

        TimeSlotId id = new TimeSlotId(timeSlotId, day, startHr, startMin);
        Optional<TimeSlotDTO> timeSlot = timeSlotService.getTimeSlotById(id);

        return timeSlot.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<TimeSlotDTO>> getAllTimeSlots() {
        List<TimeSlotDTO> timeSlots = timeSlotService.getAllTimeSlots();
        return ResponseEntity.ok(timeSlots);
    }

    @DeleteMapping("/{timeSlotId}/{day}/{startHr}/{startMin}")
    public ResponseEntity<Void> deleteTimeSlot(
            @PathVariable String timeSlotId,
            @PathVariable String day,
            @PathVariable int startHr,
            @PathVariable int startMin) {

        TimeSlotId id = new TimeSlotId(timeSlotId, day, startHr, startMin);
        boolean deleted = timeSlotService.deleteTimeSlot(id);

        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
