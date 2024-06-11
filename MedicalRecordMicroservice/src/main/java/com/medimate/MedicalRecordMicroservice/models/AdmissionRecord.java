package com.medimate.MedicalRecordMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="admission_record")
public class AdmissionRecord {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate admittedAt = ZonedDateTime.now(ZoneOffset.UTC).toLocalDate();

    private boolean urgent;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "doctor_id")
    private Integer doctorId;

    @JsonIgnore
    @OneToOne(mappedBy = "admissionRecord")
    private MedicalRecord medicalRecord;

    public AdmissionRecord(LocalDate admittedAt, boolean urgent,Integer doctor,Integer patient) {
        this.admittedAt = LocalDate.now();
        this.urgent = urgent;
        this.doctorId=doctor;
        this.patientId=patient;
    }
}
