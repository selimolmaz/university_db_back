package com.hibernate.demo.controller;

import com.hibernate.demo.dto.TakesDTO;
import com.hibernate.demo.model.TakesId;
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

    @GetMapping("/{id}/{courseId}/{secId}/{semester}/{year}")
    public ResponseEntity<TakesDTO> getTakesById(
            @PathVariable String id,
            @PathVariable String courseId,
            @PathVariable String secId,
            @PathVariable String semester,
            @PathVariable int year) {
        TakesId takesId = new TakesId(id, courseId, secId, semester, year);
        Optional<TakesDTO> takesDTO = takesService.getTakesById(takesId);
        return takesDTO.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TakesDTO>> getAllTakes() {
        List<TakesDTO> takesList = takesService.getAllTakes();
        return new ResponseEntity<>(takesList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{courseId}/{secId}/{semester}/{year}")
    public ResponseEntity<Void> deleteTakesById(
            @PathVariable String id,
            @PathVariable String courseId,
            @PathVariable String secId,
            @PathVariable String semester,
            @PathVariable int year) {
        TakesId takesId = new TakesId(id, courseId, secId, semester, year);
        takesService.deleteTakesById(takesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
