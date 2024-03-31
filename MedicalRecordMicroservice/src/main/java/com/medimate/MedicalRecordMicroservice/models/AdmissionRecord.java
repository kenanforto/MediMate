package com.medimate.MedicalRecordMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="admission_record")
public class AdmissionRecord {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private LocalDate admittedAt;

    private boolean urgent;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "doctor_id")
    private Integer doctorId;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="patient_id", insertable = false, updatable = false)
    private Patient patient;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="doctor_id", insertable = false, updatable = false)
    private Doctor doctor;

    @JsonIgnore
    @OneToOne(mappedBy = "admissionRecord")
    private MedicalRecord medicalRecord;

    protected AdmissionRecord(){}
    public AdmissionRecord(LocalDate admittedAt, boolean urgent,Integer doctor,Integer patient) {
        this.admittedAt = LocalDate.now();
        this.urgent = urgent;
        this.doctorId=doctor;
        this.patientId=patient;
    }

    public LocalDate getAdmittedAt() {
        return admittedAt;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
