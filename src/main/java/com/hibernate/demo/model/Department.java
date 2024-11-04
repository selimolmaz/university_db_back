package com.hibernate.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @Column(name = "dept_name", length = 20, insertable = false, updatable = false)
    private String deptName;

    @Column(name = "building", length = 15)
    private String building;


    @Column(name = "budget", precision = 12, scale = 2)
    @Min(value = 1, message = "Budget must be positive")
    private BigDecimal budget;
}