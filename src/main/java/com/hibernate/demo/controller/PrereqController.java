package com.hibernate.demo.controller;

import com.hibernate.demo.dto.PrereqDTO;
import com.hibernate.demo.model.PrerequisiteId;
import com.hibernate.demo.service.PrereqService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/uni/prereqs")
public class PrereqController {

    private final PrereqService prereqService;

    public PrereqController(PrereqService prereqService) {
        this.prereqService = prereqService;
    }

    @PostMapping
    public ResponseEntity<PrereqDTO> savePrereq(@RequestBody PrereqDTO prereqDTO) {
        PrereqDTO savedPrereq = prereqService.savePrereq(prereqDTO);
        return new ResponseEntity<>(savedPrereq, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PrereqDTO> updatePrereq(@RequestBody Map<String, PrereqDTO> prereqDTOs) {
        PrereqDTO existingPrereqDTO = prereqDTOs.get("existingPrereq");
        PrereqDTO newPrereqDTO = prereqDTOs.get("newPrereq");
        PrereqDTO updatedPrereq = prereqService.updatePrereq(existingPrereqDTO, newPrereqDTO);
        return new ResponseEntity<>(updatedPrereq, HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<PrereqDTO>> getPrereqByCourseId(@PathVariable String courseId) {
        List<PrereqDTO> prereqs = prereqService.getPrereqByCourseId(courseId);
        return new ResponseEntity<>(prereqs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PrereqDTO>> getAllPrereqs() {
        List<PrereqDTO> prereqs = prereqService.getAllPrereq();
        return new ResponseEntity<>(prereqs, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePrereqByCourseId(@RequestBody PrerequisiteId prerequisiteId) {
        prereqService.deletePrereqByCourseId(prerequisiteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
