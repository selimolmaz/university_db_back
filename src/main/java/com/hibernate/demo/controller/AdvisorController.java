package com.hibernate.demo.controller;

import com.hibernate.demo.dto.AdvisorDTO;
import com.hibernate.demo.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/uni/advisors")  // API için temel yol
public class AdvisorController {
    private final AdvisorService advisorService;

    @Autowired
    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;  // Servisi enjekte et
    }

    @GetMapping
    public ResponseEntity<List<AdvisorDTO>> getAllAdvisors() {
        List<AdvisorDTO> advisors = advisorService.getAllAdvisors();
        return ResponseEntity.ok(advisors);  // Tüm danışmanları döndür
    }

    @GetMapping("/{sId}")
    public ResponseEntity<AdvisorDTO> getAdvisorById(@PathVariable String sId) {
        return advisorService.getAdvisorById(sId)
                .map(ResponseEntity::ok)  // Danışman varsa döndür
                .orElse(ResponseEntity.notFound().build());  // Yoksa 404 döndür
    }

    @PostMapping("/create")
    public ResponseEntity<AdvisorDTO> createAdvisor(@RequestBody AdvisorDTO advisorDTO) {
        System.out.println("Received AdvisorDTO: " + advisorDTO);

        AdvisorDTO savedAdvisor = advisorService.saveAdvisor(advisorDTO);
        return ResponseEntity.status(201).body(savedAdvisor);  // 201 Created döndür
    }

    @PutMapping("/{sId}")
    public ResponseEntity<AdvisorDTO> updateAdvisor(@PathVariable String sId, @RequestBody AdvisorDTO advisorDTO) {
        AdvisorDTO updatedAdvisor = advisorService.updateAdvisor(sId, advisorDTO);
        if (updatedAdvisor != null) {
            return ResponseEntity.ok(updatedAdvisor);  // Güncellenen danışmanı döndür
        }
        return ResponseEntity.notFound().build();  // Eğer danışman yoksa 404 döndür
    }

    @DeleteMapping("/{sId}")
    public ResponseEntity<Void> deleteAdvisor(@PathVariable String sId) {
        boolean deleted = advisorService.deleteAdvisor(sId);
        if (deleted) {
            return ResponseEntity.noContent().build();  // 204 No Content döndür
        }
        return ResponseEntity.notFound().build();  // Eğer danışman yoksa 404 döndür
    }
}
