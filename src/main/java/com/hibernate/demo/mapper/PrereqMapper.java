package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.PrereqDTO;
import com.hibernate.demo.model.Prereq;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrereqMapper {
    PrereqDTO toDTO(Prereq prereq);
    Prereq toEntity(PrereqDTO prereqDTO);
}
