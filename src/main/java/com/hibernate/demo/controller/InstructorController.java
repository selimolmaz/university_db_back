package com.hibernate.demo.controller;

import com.hibernate.demo.dto.InstructorDTO;
import com.hibernate.demo.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uni/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // GET: Tüm Instructor kayıtlarını alır
    @GetMapping
    public ResponseEntity<List<InstructorDTO>> getAllInstructors() {
        List<InstructorDTO> instructors = instructorService.getAllInstructors();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    // GET: ID ile belirli bir Instructor kaydını alır
    @GetMapping("/{id}")
    public ResponseEntity<Optional<InstructorDTO>> getInstructorById(@PathVariable String id) {
        Optional<InstructorDTO> instructor = instructorService.getInstructorById(id);
        if (instructor.isPresent()) {
            return new ResponseEntity<>(instructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: Yeni bir Instructor kaydı oluşturur
    @PostMapping
    public ResponseEntity<InstructorDTO> createInstructor(@RequestBody InstructorDTO instructorDTO) {
        InstructorDTO createdInstructor = instructorService.saveInstructor(instructorDTO);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    // PUT: Belirli bir ID'ye sahip Instructor kaydını günceller
    @PutMapping("/{id}")
    public ResponseEntity<InstructorDTO> updateInstructor(@PathVariable String id, @RequestBody InstructorDTO instructorDTO) {
        InstructorDTO updatedInstructor = instructorService.updateInstructor(id, instructorDTO);
        if (updatedInstructor != null) {
            return new ResponseEntity<>(updatedInstructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: Belirli bir ID'ye sahip Instructor kaydını siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable String id) {
        if (instructorService.deleteInstructor(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
