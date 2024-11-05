package com.hibernate.demo.service;

import com.hibernate.demo.dto.AdvisorDTO;

import java.util.List;
import java.util.Optional;

public interface AdvisorService {
    List<AdvisorDTO> getAllAdvisors();
    Optional<AdvisorDTO> getAdvisorById(String sId);
    AdvisorDTO saveAdvisor(AdvisorDTO advisorDTO);
    AdvisorDTO updateAdvisor(String sId, AdvisorDTO advisorDTO);
    boolean deleteAdvisor(String sId);
}
