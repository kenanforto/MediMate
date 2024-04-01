package com.medimate.AdmissionMicroservice.service;

import com.medimate.AdmissionMicroservice.models.Appointment;
import com.medimate.AdmissionMicroservice.repositories.AppointmentRepository;
import com.medimate.AdmissionMicroservice.repositories.DoctorRepository;
import com.medimate.AdmissionMicroservice.repositories.PatientRepository;
import com.medimate.AdmissionMicroservice.viewModels.AppointmentVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repo;
    @Autowired
    private DoctorRepository repoDoctor;
    @Autowired
    private PatientRepository repoPatient;

    public void addAppointment(AppointmentVM appointment)
    {
        repo.save(AppointmentVM.toEntity(appointment));
    }
    public List<Appointment> getAllAppointments()
    {
        return repo.findAll();
    }
    public List<Appointment> getAppointmentsForDoctor(Integer id)
    {
        List<Appointment> appointments=repo.findAllByDoctorId(id);
        if(appointments.isEmpty()) throw new EntityNotFoundException("Could not find appointments with patient id "+id);
        return appointments;
    }
    public void deleteAppointment(Integer id)
    {
        repo.deleteById(id);
    }
}
