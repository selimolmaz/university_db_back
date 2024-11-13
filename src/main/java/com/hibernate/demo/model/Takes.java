package com.hibernate.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hibernate.demo.model.compositeIds.TakesId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "takes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TakesId.class)
public class Takes {

    @Id
    @Column(name = "ID", length = 5)
    private String studentId;

    @Id
    @Column(name = "course_id", length = 8)
    private String courseId;

    @Id
    @Column(name = "sec_id", length = 8)
    private String secId;

    @Id
    @Column(name = "semester", length = 6)
    @Check(constraints = "semester IN ('Fall', 'Winter', 'Spring', 'Summer')")
    private String semester;

    @Id
    @Column(name = "year", precision = 4, scale = 0)
    @Range(min = 1701, max = 2100, message = "Year must between 1701 and 2100")
    private int year;

    @Column(name = "grade", length = 2)
    private String grade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false),
            @JoinColumn(name = "sec_id", referencedColumnName = "sec_id", insertable = false, updatable = false),
            @JoinColumn(name = "semester", referencedColumnName = "semester", insertable = false, updatable = false),
            @JoinColumn(name = "year", referencedColumnName = "year", insertable = false, updatable = false)
    })
    private Section section;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Student student;
}
