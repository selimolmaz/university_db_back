package com.hibernate.demo.dto;

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
}
