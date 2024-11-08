package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.TeachesDTO;
import com.hibernate.demo.model.Teaches;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeachesMapper {
    TeachesDTO toDTO(Teaches teaches);
    Teaches toEntity(TeachesDTO teachesDTO);
}
