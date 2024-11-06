package com.hibernate.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "ID",length = 5)
    private String id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "tot_cred", precision = 3, scale = 0)
    @Min(value = 0, message = "Credit must be positive")
    private Integer totCred;

    @Column(name = "dept_name", length = 20)
    private String deptName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name", insertable = false, updatable = false)
    @JsonIgnore
    private Department department;
}
