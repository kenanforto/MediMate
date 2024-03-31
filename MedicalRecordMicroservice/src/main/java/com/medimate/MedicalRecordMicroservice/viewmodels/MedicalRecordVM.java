package com.medimate.MedicalRecordMicroservice.viewmodels;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MedicalRecordVM {

    private String description;

    private LocalDate createdDate;

    private Integer patientId;

    private Integer doctorId;

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
