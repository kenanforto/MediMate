package com.medimate.MedicalRecordMicroservice.viewmodels;

import lombok.Getter;

import java.time.LocalDate;

@Getter
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

}
