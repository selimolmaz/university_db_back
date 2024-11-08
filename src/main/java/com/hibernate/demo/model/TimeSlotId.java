package com.hibernate.demo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TimeSlotId implements Serializable {
    private String timeSlotId;
    private String day;
    private int startHr;
    private int startMin;
}
