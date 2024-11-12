package com.hibernate.demo.service;

import com.hibernate.demo.dto.PrereqDTO;
import com.hibernate.demo.model.compositeIds.PrerequisiteId;

import java.util.List;

public interface PrereqService {
    PrereqDTO savePrereq(PrereqDTO prereqDTO);
    List<PrereqDTO> getPrereqByCourseId(String courseId);
    List<PrereqDTO> getAllPrereq();
    void deletePrereqByCourseId(PrerequisiteId prerequisiteId);
    PrereqDTO updatePrereq(PrereqDTO existingPrereqDTO, PrereqDTO newPrereqDTO);
}
