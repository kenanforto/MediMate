package com.medimate.MedicalRecordMicroservice.viewmodels;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MedicalRecordVM {

    @NotBlank
    @NotNull
    private String description;

    private LocalDate createdDate;

    @NotNull
    private Integer patientId;

    @NotNull
    private Integer doctorId;

    @NotNull
    private Integer admissionRecordId;

    public MedicalRecordVM(String description,Integer doctorId,Integer patientId,Integer admissionId) {
        this.description = description;
        this.createdDate = LocalDate.now();
        this.patientId=patientId;
        this.doctorId=doctorId;
        this.admissionRecordId=admissionId;
    }

    public static MedicalRecord toEntity(MedicalRecordVM medicalRecordVM) {
        return new MedicalRecord(medicalRecordVM.description, medicalRecordVM.patientId, medicalRecordVM.doctorId, medicalRecordVM.admissionRecordId);
    }

}
