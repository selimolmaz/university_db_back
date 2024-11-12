package com.hibernate.demo.service;

import com.hibernate.demo.dto.TakesDTO;
import com.hibernate.demo.model.compositeIds.TakesId;

import java.util.List;
import java.util.Optional;

public interface TakesService {
    TakesDTO saveTakes(TakesDTO takesDTO);
    Optional<TakesDTO> getTakesById(TakesId takesId);
    List<TakesDTO> getAllTakesByStudentId(String studentId);
    List<TakesDTO> getAllTakes();
    void deleteTakesById(TakesId takesId);
}
