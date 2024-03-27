package com.medimate.MedicalRecordMicroservice.viewmodels;

import java.time.LocalDate;

public class MedicalRecordVM {
    private String description;
    private LocalDate createdDate;

    private Integer patientId;
    private Integer doctorId;
    private Integer admissionId;

    public MedicalRecordVM(String description,Integer doctorId,Integer patientId,Integer admissionId) {
        this.description = description;
        this.createdDate = LocalDate.now();
        this.patientId=patientId;
        this.doctorId=doctorId;
        this.admissionId=admissionId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public Integer getAdmissionId() {
        return admissionId;
    }
}