package com.hibernate.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "time_slot")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(TimeSlotId.class)
public class TimeSlot {

    @Id
    @Column(name = "time_slot_id", length = 4)
    private String timeSlotId;

    @Id
    @Column(name = "day", length = 1)
    private String day;

    @Id
    @Column(name = "start_hr")
    @Range(min = 0, max = 23, message = "Start hour must be between 0 and 23.")
    private int startHr;

    @Id
    @Column(name = "start_min")
    @Range(min = 0, max = 59, message = "Start minute must be between 0 and 59.")
    private int startMin;

    @Column(name = "end_hr")
    @Range(min = 0, max = 23, message = "End hour must be between 0 and 23.")
    private int endHr;

    @Column(name = "end_min")
    @Range(min = 0, max = 59, message = "End minute must be between 0 and 59.")
    private int endMin;
}
