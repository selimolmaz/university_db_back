package com.hibernate.demo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakesId implements Serializable {
    private String id;
    private String courseId;
    private String secId;
    private String semester;
    private int year;
}
