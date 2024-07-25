package com.hansel.springtransactional.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "patient_name", nullable = false, length = 50) // use length to limit the length of the column
    private String patientName;

    @Column(name = "patient_email", nullable = false, length = 50)
    private String patientEmail;

    @Column(name = "patient_phone_no", nullable = false, length = 50)
    private String patientPhoneNo;

    /*  @JsonManagedReference: This annotation is used on the parent side of the relationship (in Patient), indicating that this side should be serialized. */
    /* be careful: add annotation one to many and many to one can trigger n+1 problem by default if not using EntityGraph */
    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private Set<Appointment> appointments = new LinkedHashSet<>();

}