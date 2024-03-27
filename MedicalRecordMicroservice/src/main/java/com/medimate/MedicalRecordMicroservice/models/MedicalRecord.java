package com.medimate.MedicalRecordMicroservice.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="medical_record")
public class MedicalRecord {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name="admissionRecord_id")
    private AdmissionRecord admissionRecord;

    protected MedicalRecord(){}
    public MedicalRecord(String description,Doctor doctor,Patient patient,AdmissionRecord admissionRecord) {
        this.description = description;
        this.createdDate=LocalDate.now();
        this.doctor=doctor;
        this.patient=patient;
        this.admissionRecord=admissionRecord;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public AdmissionRecord getAdmissionRecord() {
        return admissionRecord;
    }
}
