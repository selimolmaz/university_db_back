package com.hibernate.demo.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class DepartmentDTO {
    private String deptName;
    private String building;
    private BigDecimal budget;
}