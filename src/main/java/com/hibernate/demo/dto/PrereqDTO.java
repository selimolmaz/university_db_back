package com.hibernate.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrereqDTO {
    private String courseId;
    private String prereqId;
    private CourseDTO course;
    private CourseDTO prerequisiteCourse;
}
