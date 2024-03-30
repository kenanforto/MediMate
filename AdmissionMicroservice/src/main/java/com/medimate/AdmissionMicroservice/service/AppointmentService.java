package com.medimate.AdmissionMicroservice.service;

import com.medimate.AdmissionMicroservice.models.Appointment;
import com.medimate.AdmissionMicroservice.repositories.AppointmentRepository;
import com.medimate.AdmissionMicroservice.repositories.DoctorRepository;
import com.medimate.AdmissionMicroservice.repositories.PatientRepository;
import com.medimate.AdmissionMicroservice.viewModels.AppointmentVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repo;
    @Autowired
    private DoctorRepository repoDoctor;
    @Autowired
    private PatientRepository repoPatient;

    public void addOneAppointment(AppointmentVM appointment)
    {
        repo.save( new Appointment(appointment.getAppointmentDateTime(),
                repoDoctor.findById(appointment.getDoctorId()).orElse(null),
                repoPatient.findById(appointment.getPatientId()).orElse(null))
        );
    }
    public List<Appointment> getAllAppointments()
    {
        return repo.findAll();
    }
    public List<Appointment> getAppointmentsForDoctor(Integer id)
    {
        return repo.findAllByDoctorId(id);
    }
    public void deleteOneAppointment(Integer id)
    {
        repo.deleteById(id);
    }
}
