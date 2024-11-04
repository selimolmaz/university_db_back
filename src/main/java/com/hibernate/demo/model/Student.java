package com.hibernate.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @Column(name = "ID",length = 5)
    private String id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "tot_cred", precision = 3, scale = 0)
    @Min(value = 0, message = "Credit must be positive")
    private Integer totCred;

    @ManyToOne
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name",
            foreignKey = @ForeignKey(name = "FK_Student_Department"),
            nullable = true)
    private Department department;
}
