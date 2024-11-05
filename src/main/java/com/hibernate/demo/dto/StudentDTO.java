package com.hibernate.demo.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private String id;
    private String name;
    private Integer totCred;
    private String deptName;
}
