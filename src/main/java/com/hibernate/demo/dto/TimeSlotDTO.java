package com.hibernate.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotDTO {
    private String timeSlotId;
    private String day;
    private int startHr;
    private int startMin;
    private int endHr;
    private int endMin;
}
