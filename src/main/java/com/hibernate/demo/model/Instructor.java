package com.hibernate.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "instructor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @Column(name = "ID", length = 5)
    private String id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "salary", precision = 8, scale = 2)
    @Min(value = 28999, message = "Salart must be greater than 29000")
    private BigDecimal salary;

    @Column(name = "dept_name", length = 20)
    private String deptName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name", insertable = false, updatable = false)
    private Department department;
}
