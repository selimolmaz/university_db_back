package com.hibernate.demo.model.compositeIds;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrerequisiteId implements Serializable {
    private String courseId;
    private String prereqId;
}
