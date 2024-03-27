package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.DoctorRepository;
import com.medimate.WorkingHoursMicroservice.repositories.TrackWorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.repositories.WorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.WorkingHoursVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkingHoursService {

    @Autowired
    private WorkingHoursRepository repo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private TrackWorkingHoursRepository trackWHRepo;

    public WorkingHours addOne(WorkingHoursVM workingHoursVM){
        return repo.save(
                new WorkingHours(
                        workingHoursVM.getStartTime(),
                        workingHoursVM.getEndTime(),
                        workingHoursVM.getTitle(),
                        doctorRepo.findById(workingHoursVM.getDoctorId()).orElse(null),
                        trackWHRepo.findById(workingHoursVM.getTrackWorkingHoursId()).orElse(null))
        );
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public WorkingHours getById(Integer id) {
        Optional<WorkingHours> workingHoursOptional = repo.findById(id);
        return workingHoursOptional.orElseThrow(() -> new EntityNotFoundException("Could not find working hours with id %d".formatted(id)));
    }
}
