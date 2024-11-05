package com.hibernate.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "advisor")
@Data
public class Advisor {
    @Id
    @Column(name = "s_ID", length = 5)
    private String sId;  // This will be our primary key

    @Column(name = "i_ID", length = 5)
    private String iId;

    @OneToOne(fetch = FetchType.LAZY) // non-owning side of the relationship
    @JoinColumn(name = "s_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY) // non-owning side of the relationship
    @JoinColumn(name = "i_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Instructor instructor;
}