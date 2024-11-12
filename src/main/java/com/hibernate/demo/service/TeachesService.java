package com.hibernate.demo.service;

import com.hibernate.demo.dto.TeachesDTO;
import com.hibernate.demo.model.compositeIds.TeachesId;

import java.util.List;
import java.util.Optional;

public interface TeachesService {

    Optional<TeachesDTO> getTeachesById(TeachesId id);

    List<TeachesDTO> getAllTeaches();

    TeachesDTO saveTeaches(TeachesDTO teachesDTO);

    boolean deleteTeaches(TeachesDTO teachesDTO);
}
