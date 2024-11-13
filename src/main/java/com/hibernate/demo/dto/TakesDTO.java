package com.hibernate.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakesDTO {
    private String studentId;
    private String courseId;
    private String secId;
    private String semester;
    private int year;
    private String grade;
    private SectionDTO section;
    private StudentDTO student;
}
