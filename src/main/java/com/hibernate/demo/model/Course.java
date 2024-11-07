package com.hibernate.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @Column(name = "course_id", length = 8)
    private String courseId;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "dept_name", length = 20)
    private String deptName;

    @Column(name = "credits", precision = 2, scale = 0)
    @Min(value = 0, message = "Credit must be positive")
    private BigDecimal credits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name", insertable = false, updatable = false)
    @JsonIgnore
    private Department department;
}
