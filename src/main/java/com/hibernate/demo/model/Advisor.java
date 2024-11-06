package com.hibernate.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "advisor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {

    @Id
    @Column(name = "s_ID", length = 5)
    private String sid;

    @Column(name = "i_ID", length = 5)
    private String iid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "i_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    private Instructor instructor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @JsonIgnore
    private Student student;
}