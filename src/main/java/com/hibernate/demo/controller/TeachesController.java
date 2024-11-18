package com.hibernate.demo.controller;

import com.hibernate.demo.dto.SectionDTO;
import com.hibernate.demo.dto.TeachesDTO;
import com.hibernate.demo.service.TeachesService;
import com.hibernate.demo.model.compositeIds.TeachesId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uni/teaches")
public class TeachesController {

    private final TeachesService teachesService;

    @Autowired
    public TeachesController(TeachesService teachesService) {
        this.teachesService = teachesService;
    }

    @GetMapping("/{id}/{courseId}/{secId}/{semester}/{year}")
    public ResponseEntity<TeachesDTO> getTeachesById(
            @PathVariable String id,
            @PathVariable String courseId,
            @PathVariable String secId,
            @PathVariable String semester,
            @PathVariable int year) {
        TeachesId teachesId = new TeachesId(id, courseId, secId, semester, year);
        return teachesService.getTeachesById(teachesId)
                .map(teachesDTO -> new ResponseEntity<>(teachesDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    public ResponseEntity<List<TeachesDTO>> getAllTeaches() {
        List<TeachesDTO> teachesDTOList = teachesService.getAllTeaches();
        return new ResponseEntity<>(teachesDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeachesDTO> saveTeaches(@RequestBody TeachesDTO teachesDTO) {
        TeachesDTO savedTeachesDTO = teachesService.saveTeaches(teachesDTO);
        return new ResponseEntity<>(savedTeachesDTO, HttpStatus.CREATED);
    }

    @GetMapping("/section")
    public ResponseEntity<TeachesDTO> getTeachesBySection(@RequestBody SectionDTO sectionDTO) {
        return teachesService.getTeachesBySection(sectionDTO)
                .map(teachesDTO -> new ResponseEntity<>(teachesDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<List<TeachesDTO>> getTeachesByInstructorId(@PathVariable String instructorId) {
        List<TeachesDTO> instructorDTOS = teachesService.getteachesByInstructorId(instructorId);
        return new ResponseEntity<>(instructorDTOS, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTeaches(@RequestBody TeachesDTO teachesDTO) {
        boolean deleted = teachesService.deleteTeaches(teachesDTO);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
