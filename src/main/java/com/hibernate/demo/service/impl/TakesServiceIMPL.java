package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.TakesDTO;
import com.hibernate.demo.mapper.TakesMapper;
import com.hibernate.demo.model.Takes;
import com.hibernate.demo.model.TakesId;
import com.hibernate.demo.repository.TakesRepository;
import com.hibernate.demo.service.TakesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TakesServiceIMPL implements TakesService {

    private final TakesRepository takesRepository;
    private final TakesMapper takesMapper;

    public TakesServiceIMPL(TakesRepository takesRepository, TakesMapper takesMapper) {
        this.takesRepository = takesRepository;
        this.takesMapper = takesMapper;
    }

    @Override
    public TakesDTO saveTakes(TakesDTO takesDTO) {
        Takes takes = takesMapper.toEntity(takesDTO);
        Takes savedTakes = takesRepository.save(takes);
        return takesMapper.toDTO(savedTakes);
    }

    @Override
    public Optional<TakesDTO> getTakesById(TakesId takesId) {
        return takesRepository.findById(takesId)
                .map(takesMapper::toDTO);
    }

    @Override
    public List<TakesDTO> getAllTakesByStudentId(String studentId) {
        return takesRepository.findByStudentId(studentId)
                .stream()
                .map(takesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TakesDTO> getAllTakes() {
        return takesRepository.findAll()
                .stream()
                .map(takesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTakesById(TakesId takesId) {
        takesRepository.deleteById(takesId);
    }
}
