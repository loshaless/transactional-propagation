package com.hansel.springtransactional.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /* @JsonBackReference: This annotation is used on the child side of the relationship (in Appointment), indicating that this side should not be serialized to prevent the infinite loop. */
    /* be careful: add annotation one to many and many to one can trigger n+1 problem by default if not using EntityGraph */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference
    private Patient patient;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @ColumnDefault("CURRENT_TIME")
    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @Column(name = "appointment_note", length = 1000)
    private String appointmentNote;

}