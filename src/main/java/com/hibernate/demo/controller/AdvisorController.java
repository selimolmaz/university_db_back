package com.hibernate.demo.controller;

import com.hibernate.demo.dto.AdvisorDTO;
import com.hibernate.demo.service.AdvisorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uni/advisors")
public class AdvisorController {

    private final AdvisorService advisorService;

    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @PostMapping
    public ResponseEntity<AdvisorDTO> saveAdvisor(@RequestBody AdvisorDTO advisorDTO) {
        AdvisorDTO savedAdvisor = advisorService.saveAdvisor(advisorDTO);
        return new ResponseEntity<>(savedAdvisor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvisorDTO> updateAdvisor(@PathVariable String id, @RequestBody AdvisorDTO advisorDTO) {
        Optional<AdvisorDTO> existAdvisor = advisorService.getAdvisorById(id);
        if (existAdvisor.isPresent()){
            AdvisorDTO updatedAdvisor = advisorService.saveAdvisor(advisorDTO);
            return new ResponseEntity<>(updatedAdvisor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<AdvisorDTO>> getAllAdvisor(){
        List<AdvisorDTO> advisorDTOS = advisorService.getAllAdvisors();
        return new ResponseEntity<>(advisorDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvisorDTO> getAdvisorById(@PathVariable String id) {
        return advisorService.getAdvisorById(id)
                .map(advisorDTO -> new ResponseEntity<>(advisorDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvisorById(@PathVariable String id) {
        advisorService.deleteAdvisorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
