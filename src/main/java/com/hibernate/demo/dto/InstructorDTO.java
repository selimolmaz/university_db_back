package com.hibernate.demo.dto;

import lombok.Data;

@Data
public class InstructorDTO {
    private String id;
    private String name;
    private Integer salary;
    private String deptName; // Department adı için sadece String alan
}
