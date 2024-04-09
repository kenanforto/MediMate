package com.medimate.AdmissionMicroservice.controllers;

import com.medimate.AdmissionMicroservice.models.Appointment;
import com.medimate.AdmissionMicroservice.service.AppointmentService;
import com.medimate.AdmissionMicroservice.viewModels.AppointmentVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment addAppointment(@Valid @RequestBody AppointmentVM appointment)
    {
        return appointmentService.addAppointment(appointment);
    }
    @GetMapping(path="/all")
    public List<Appointment> getAllAppointments()
    {
       return appointmentService.getAllAppointments();
    }
    @GetMapping(path="/doctor/{doctorId}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable Integer doctorId)
    {
         return appointmentService.getAppointmentsForDoctor(doctorId);
    }
    @DeleteMapping(path="/delete/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Integer appointmentId)
    {
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }
}
