package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.repositories.DoctorRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.DoctorVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

  @Autowired
  DoctorRepository repo;


  public void addOne(DoctorVM doctorVM){
      repo.save(
              new Doctor(
                      doctorVM.getFirstName(),
                      doctorVM.getLastName(),
                      doctorVM.getTitle()
              )
      );
  }

  public void deleteById(Integer id){
      repo.deleteById(id);
  }

  public Doctor getById(Integer id){
      Optional<Doctor> doctorOptional = repo.findById(id);
      return doctorOptional.orElse(null);
  }

}
