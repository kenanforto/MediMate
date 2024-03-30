package com.medimate.AdmissionMicroservice.models;


import jakarta.persistence.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime appointmentDateTime;

    private LocalDateTime createdDate = ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment(LocalDateTime appointmentDateTime, Doctor doctor,Patient patient) {
        this.appointmentDateTime = appointmentDateTime;
        this.doctor=doctor;
        this.patient=patient;
    }

    public Appointment() {}

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
