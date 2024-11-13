package com.hibernate.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachesDTO {
    private String id;
    private String courseId;
    private String secId;
    private String semester;
    private int year;
    private SectionDTO section;
    private InstructorDTO instructor;
}
