package com.medimate.AdmissionMicroservice.service;

import com.medimate.AdmissionMicroservice.models.Appointment;
import com.medimate.AdmissionMicroservice.models.Doctor;
import com.medimate.AdmissionMicroservice.repositories.AppointmentRepository;
import com.medimate.AdmissionMicroservice.repositories.DoctorRepository;
import com.medimate.AdmissionMicroservice.repositories.PatientRepository;
import com.medimate.AdmissionMicroservice.viewModels.AppointmentVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Appointment addAppointment(AppointmentVM appointment) {
        return repo.save(AppointmentVM.toEntity(appointment));
    }

    public Page<Appointment> getAllAppointments(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Appointment> appointments = repo.findAll(pageable);
        if (appointments.isEmpty()) {
            throw new EntityNotFoundException("There are no appointments");
        }
        return appointments;
    }

    public List<Appointment> getAppointmentsForDoctor(Integer id) {
        List<Appointment> appointments = repo.findAllByDoctorId(id);
        if (appointments.isEmpty())
            throw new EntityNotFoundException("Could not find appointments with doctor id " + id);
        return appointments;
    }

    public void deleteAppointment(Integer id) {
        repo.deleteById(id);
    }
}
