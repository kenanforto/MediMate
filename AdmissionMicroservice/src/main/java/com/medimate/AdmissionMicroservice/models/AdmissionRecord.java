package com.medimate.AdmissionMicroservice.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name = "admission_record")
public class AdmissionRecord {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime admittedAt = ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();

    private boolean urgent;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public AdmissionRecord(Integer id, LocalDateTime admittedAt, boolean urgent) {
        this.id = id;
        this.urgent = urgent;
    }

    public AdmissionRecord() {}
}
