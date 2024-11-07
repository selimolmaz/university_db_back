package com.hibernate.demo.service;

import com.hibernate.demo.dto.AdvisorDTO;

import java.util.List;
import java.util.Optional;

public interface AdvisorService {
    AdvisorDTO saveAdvisor(AdvisorDTO advisorDTO);
    Optional<AdvisorDTO> getAdvisorById(String studentId);
    List<AdvisorDTO> getAllAdvisors();
    void deleteAdvisorById(String studentId);
}
