package com.medimate.AdmissionMicroservice.controllers;

import com.medimate.AdmissionMicroservice.models.Appointment;
import com.medimate.AdmissionMicroservice.models.Doctor;
import com.medimate.AdmissionMicroservice.service.AppointmentService;
import com.medimate.AdmissionMicroservice.viewModels.AppointmentVM;
import com.medimate.AdmissionMicroservice.viewModels.DoctorVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Appointment addAppointment(@Valid @RequestBody AppointmentVM appointment) {
        ResponseEntity<DoctorVM> doctor=restTemplate.getForEntity("http://USERMICROSERVICE/doctors/{id}", DoctorVM.class,appointment.getDoctorId());
        DoctorVM doctor1=doctor.getBody();
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
