package com.medimate.MedicalRecordMicroservice.viewmodels;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AdmissionRecordVM {

    private LocalDate admittedAt;

    @NotNull
    private boolean urgent;

    @NotNull
    private Integer doctorId;

    @NotNull
    private Integer patientId;

    public AdmissionRecordVM(LocalDate admittedAt, boolean urgent,Integer doctorId,Integer patientId) {
        this.admittedAt = admittedAt;
        this.urgent = urgent;
        this.doctorId=doctorId;
        this.patientId=patientId;
    }

    public static AdmissionRecord toEntity(AdmissionRecordVM admissionRecordVM) {
        return new AdmissionRecord(admissionRecordVM.admittedAt, admissionRecordVM.urgent, admissionRecordVM.doctorId, admissionRecordVM.patientId);
    }

}
