package com.hibernate.demo.dto;

import com.hibernate.demo.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvisorDTO {
    private String sid;
    private String iid;
    private InstructorDTO instructor;
    private StudentDTO student;
}
