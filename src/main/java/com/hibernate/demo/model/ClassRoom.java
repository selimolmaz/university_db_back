package com.hibernate.demo.model;

import com.hibernate.demo.model.compositeIds.ClassRoomId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "classroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ClassRoomId.class)
public class ClassRoom {

    @Id
    @Column(name = "building", length = 15)
    private String building;

    @Id
    @Column(name = "room_number", length = 7)
    private String roomNumber;

    @Column(name = "capacity", precision = 4, scale = 0)
    @Min(value = 0, message = "Capacity must be positive!")
    private BigDecimal capacity;
}
