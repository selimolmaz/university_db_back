package com.hibernate.demo.dto;

import com.hibernate.demo.model.ClassRoom;
import com.hibernate.demo.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDTO {
    private String courseId;
    private String secId;
    private String semester;
    private int year;
    private String building;
    private String roomNumber;
    private String timeSlotId;
    private Course course;
    private ClassRoom classRoom;
}
