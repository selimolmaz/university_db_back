package com.hibernate.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Table(name = "instructor")
@Data
public class Instructor {
    @Id
    @Column(name = "ID", length = 5)
    private String id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "salary", precision = 8, scale = 2)
    @Min(value = 28999, message = "Salart must be greater than 29000")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name",
            foreignKey = @ForeignKey(name = "FK_Instructor_Department"),
            nullable = true)
    private Department department;
}
