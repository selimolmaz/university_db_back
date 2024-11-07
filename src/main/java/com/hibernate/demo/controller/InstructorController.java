package com.hibernate.demo.controller;

import com.hibernate.demo.dto.InstructorDTO;
import com.hibernate.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uni/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<InstructorDTO> saveInstructor(@RequestBody InstructorDTO instructorDTO) {
        InstructorDTO savedInstructor = instructorService.saveInstructor(instructorDTO);
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorDTO> updateInstructor(@PathVariable String id, @RequestBody InstructorDTO instructorDTO) {
        Optional<InstructorDTO> existInstructor = instructorService.getInstructorById(id);
        if (existInstructor.isPresent()) {
            instructorDTO.setId(id);
            InstructorDTO updatedInstructor = instructorService.saveInstructor(instructorDTO);
            return new ResponseEntity<>(updatedInstructor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<InstructorDTO>> getAllInstructors() {
        List<InstructorDTO> instructorDTOS = instructorService.getAllInstructor();
        return new ResponseEntity<>(instructorDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDTO> getInstructorById(@PathVariable String id) {
        return instructorService.getInstructorById(id)
                .map(instructorDTO -> new ResponseEntity<>(instructorDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructorById(@PathVariable String id){
        instructorService.deleteInstructorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
