package com.medimate.AppointmentMicroservice.repositories;

import com.medimate.AppointmentMicroservice.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    List<Appointment> findAllByDoctorId(Integer doctorId);
}
