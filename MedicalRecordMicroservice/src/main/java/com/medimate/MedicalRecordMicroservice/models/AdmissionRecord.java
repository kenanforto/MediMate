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
    @OneToOne(mappedBy = "admissionRecord")
    private MedicalRecord medicalRecord;

    protected AdmissionRecord(){}
    public AdmissionRecord(LocalDate admittedAt, boolean urgent,Doctor doctor,Patient patient) {
        this.admittedAt = LocalDate.now();
        this.urgent = urgent;
        this.doctor=doctor;
        this.patient=patient;
    }

    public LocalDate getAdmittedAt() {
        return admittedAt;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
