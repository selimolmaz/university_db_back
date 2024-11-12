package com.hibernate.demo.model;

import com.hibernate.demo.model.compositeIds.SectionId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "building", referencedColumnName = "building", insertable = false, updatable = false),
            @JoinColumn(name = "room_number", referencedColumnName = "room_number", insertable = false, updatable = false)
    })
    private ClassRoom classRoom;
}
