package com.medimate.AppointmentMicroservice.viewModels;

import com.medimate.AppointmentMicroservice.models.Appointment;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AppointmentVM {
    @NotNull
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDateTime appointmentDateTime;
    private LocalDateTime createdDate;
    @NotNull
    private Integer doctorId;
    @NotNull
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
    public static Appointment toEntity(AppointmentVM appointmentVM)
    {
        return new Appointment(appointmentVM.appointmentDateTime,appointmentVM.doctorId,appointmentVM.patientId);
    }
}
