package com.hibernate.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prereq")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PrerequisiteId.class)
public class Prereq {
    @Id
    @Column(name = "course_id", length = 8)
    private String courseId;
    @Id
    @Column(name = "prereq_id", length = 8)
    private String prereqId;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "prereq_id", referencedColumnName = "course_id", insertable = false, updatable = false)
    private Course prerequisiteCourse;

}

