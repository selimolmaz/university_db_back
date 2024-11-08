package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.TakesDTO;
import com.hibernate.demo.model.Takes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TakesMapper {
    TakesDTO toDTO(Takes takes);
    Takes toEntity(TakesDTO takesDTO);
}
