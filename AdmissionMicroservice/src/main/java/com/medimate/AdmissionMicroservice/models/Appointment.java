package com.medimate.AdmissionMicroservice.models;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime appointmentDateTime;

    private LocalDateTime createdDate = ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment(Integer id, LocalDateTime appointmentDateTime) {
        this.id = id;
        this.appointmentDateTime = appointmentDateTime;
    }

    public Appointment() {}
}
