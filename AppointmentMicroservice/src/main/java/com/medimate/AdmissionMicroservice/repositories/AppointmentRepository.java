package com.medimate.AdmissionMicroservice.repositories;

import com.medimate.AdmissionMicroservice.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    List<Appointment> findAllByDoctorId(Integer doctorId);
}
