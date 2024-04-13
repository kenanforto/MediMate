package com.medimate.AdmissionMicroservice.controllers;

import com.medimate.AdmissionMicroservice.models.Appointment;
import com.medimate.AdmissionMicroservice.models.Doctor;
import com.medimate.AdmissionMicroservice.service.AppointmentService;
import com.medimate.AdmissionMicroservice.viewModels.AppointmentVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment addAppointment(@Valid @RequestBody AppointmentVM appointment) {
        return appointmentService.addAppointment(appointment);
    }

    @GetMapping
    public ResponseEntity<Page<Appointment>> getAllAppointments(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<Appointment> appointments = appointmentService.getAllAppointments(page, size, sortBy);
        return (appointments != null && !appointments.isEmpty()) ? ResponseEntity.ok().body(appointments) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "doctor/{doctorId}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable Integer doctorId) {
        return appointmentService.getAppointmentsForDoctor(doctorId);
    }

    @DeleteMapping(path = "{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Integer appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }
}
