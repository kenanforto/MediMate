package com.medimate.MedicalRecordMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name="medical_record")
public class MedicalRecord {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    @NotNull
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

    public MedicalRecord(){}
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
