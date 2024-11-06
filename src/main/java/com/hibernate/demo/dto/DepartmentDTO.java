package com.hibernate.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private String deptName;
    private String building;
    private BigDecimal budget;
}