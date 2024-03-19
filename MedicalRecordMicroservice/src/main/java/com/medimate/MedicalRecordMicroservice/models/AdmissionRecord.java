package com.medimate.MedicalRecordMicroservice.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="admission_record")
public class AdmissionRecord {

    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate admittedAt;
    private boolean urgent;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name="medicalRecord_id")
    private MedicalRecord medicalRecord;

    protected AdmissionRecord(){}
    public AdmissionRecord(Integer id, boolean urgent) {
        this.id = id;
        this.admittedAt = LocalDate.now();
        this.urgent = urgent;
    }
}
