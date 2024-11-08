package com.hibernate.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Entity
@Table(name = "section")
@IdClass(SectionId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Check(constraints = "semester IN ('Fall', 'Winter', 'Spring', 'Summer')")
@Check(constraints = "year > 1701 AND year < 2100")
public class Section {

    @Id
    @Column(name = "course_id", length = 8)
    private String courseId;

    @Id
    @Column(name = "sec_id", length = 8)
    private String secId;

    @Id
    @Column(name = "semester", length = 6)
    private String semester;

    @Id
    @Column(name = "year", precision = 4, scale = 0)
    private int year;

    @Column(name = "building", length = 15)
    private String building;

    @Column(name = "room_number", length = 7)
    private String roomNumber;

    @Column(name = "time_slot_id", length = 4)
    private String timeSlotId;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "building", referencedColumnName = "building", insertable = false, updatable = false),
            @JoinColumn(name = "room_number", referencedColumnName = "room_number", insertable = false, updatable = false)
    })
    private ClassRoom classRoom;
}
