package com.medimate.AdmissionMicroservice.controllers;

import com.medimate.AdmissionMicroservice.models.Appointment;
import com.medimate.AdmissionMicroservice.service.AppointmentService;
import com.medimate.AdmissionMicroservice.viewModels.AppointmentVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(path="/getall")
    public List<Appointment> getAllAppointments()
    {
       return appointmentService.getAllAppointments();
    }
    @GetMapping(path="/get/{id}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable Integer id)
    {
         return appointmentService.getAppointmentsForDoctor(id);
    }
    @PostMapping(path="/add")
    public void addAppointment(@RequestBody AppointmentVM appointment)
    {
        appointmentService.addOneAppointment(appointment);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteOneAppointment(@PathVariable Integer id)
    {
        appointmentService.deleteOneAppointment(id);
    }
}
