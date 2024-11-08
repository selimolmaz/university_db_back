package com.hibernate.demo.mapper;

import com.hibernate.demo.dto.SectionDTO;
import com.hibernate.demo.model.Section;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SectionMapper {
    SectionDTO toDTO(Section section);
    Section toEntity(SectionDTO sectionDTO);
}
