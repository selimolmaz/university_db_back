package com.hibernate.demo.controller;

import com.hibernate.demo.dto.TakesDTO;
import com.hibernate.demo.model.compositeIds.TakesId;
import com.hibernate.demo.service.TakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uni/takes")
public class TakesController {

    private final TakesService takesService;

    @Autowired
    public TakesController(TakesService takesService) {
        this.takesService = takesService;
    }

    @PostMapping
    public ResponseEntity<TakesDTO> saveTakes(@RequestBody TakesDTO takesDTO) {
        TakesDTO savedTakes = takesService.saveTakes(takesDTO);
        return new ResponseEntity<>(savedTakes, HttpStatus.CREATED);
    }

    @GetMapping("/takesId")
    public ResponseEntity<TakesDTO> getTakesById(@RequestBody TakesId takesId) {
        Optional<TakesDTO> takesDTO = takesService.getTakesById(takesId);
        return takesDTO.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<TakesDTO>> getStudentTakesById(@PathVariable String studentId) {
        List<TakesDTO> takesDTOS = takesService.getAllTakesByStudentId(studentId);
        return new ResponseEntity<>(takesDTOS, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TakesDTO>> getAllTakes() {
        List<TakesDTO> takesList = takesService.getAllTakes();
        return new ResponseEntity<>(takesList, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTakesById(@RequestBody TakesId takesId) {
        takesService.deleteTakesById(takesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
