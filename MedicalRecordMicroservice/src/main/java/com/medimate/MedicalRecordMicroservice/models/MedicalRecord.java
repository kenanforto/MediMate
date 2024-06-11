package com.medimate.MedicalRecordMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @NotNull
    private Integer patientId;

    @Column(name = "doctor_id")
    @NotNull
    private Integer doctorId;

    @Column(name = "admission_record_id")
    @NotNull
    private Integer admissionRecordId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="admission_record_id", insertable = false, updatable = false)
    private AdmissionRecord admissionRecord;

    public MedicalRecord(String description, Integer patientId, Integer doctorId, Integer admissionRecordId) {
        this.description = description;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.admissionRecordId = admissionRecordId;
    }
}
