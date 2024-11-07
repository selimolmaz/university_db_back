package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.AdvisorDTO;
import com.hibernate.demo.model.Advisor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdvisorMapper {
    AdvisorDTO toDTO(Advisor advisor);
    Advisor toEntity(AdvisorDTO advisorDTO);
}
