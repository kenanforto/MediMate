package com.medimate.AdmissionMicroservice.viewModels;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentVM {
    private LocalDateTime appointmentDateTime;
    private LocalDateTime createdDate;
    private Integer doctorId;
    private Integer patientId;

    public AppointmentVM(LocalDateTime appointmentDateTime, Integer doctorId, Integer patientId) {
        this.appointmentDateTime = appointmentDateTime;
        this.createdDate = LocalDateTime.now();
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }
}
