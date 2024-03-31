package com.medimate.MedicalRecordMicroservice.viewmodels;

import java.time.LocalDate;

public class AdmissionRecordVM {
    private LocalDate admittedAt;
    private boolean urgent;
    private Integer doctorId;
    private Integer patientId;

    public AdmissionRecordVM(LocalDate admittedAt, boolean urgent,Integer doctorId,Integer patientId) {
        this.admittedAt = admittedAt;
        this.urgent = urgent;
        this.doctorId=doctorId;
        this.patientId=patientId;
    }

    public LocalDate getAdmittedAt() {
        return admittedAt;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }
}
