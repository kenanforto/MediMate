package com.medimate.MedicalRecordMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name="medical_record")
public class MedicalRecord {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    @NotNull
    private String description;
    private LocalDateTime createdDate = ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "admission_record_id")
    private Integer admissionRecordId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="patient_id", insertable = false, updatable = false)
    private Patient patient;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="doctor_id", insertable = false, updatable = false)
    private Doctor doctor;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="admission_record_id", insertable = false, updatable = false)
    private AdmissionRecord admissionRecord;

    public MedicalRecord(){}

    public MedicalRecord(Integer id, String description, Integer patientId, Integer doctorId, Integer admissionRecordId) {
        this.id = id;
        this.description = description;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.admissionRecordId = admissionRecordId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getAdmissionRecordId() {
        return admissionRecordId;
    }

    public void setAdmissionRecordId(Integer admissionRecordId) {
        this.admissionRecordId = admissionRecordId;
    }

    public String getDescription() {
        return description;
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
