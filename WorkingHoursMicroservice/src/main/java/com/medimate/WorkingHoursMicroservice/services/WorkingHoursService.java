package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.DoctorRepository;
import com.medimate.WorkingHoursMicroservice.repositories.TrackWorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.repositories.WorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.WorkingHoursVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingHoursService {

    @Autowired
    private WorkingHoursRepository repo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private TrackWorkingHoursRepository trackWHRepo;

    public WorkingHours addOne(WorkingHoursVM workingHoursVM)
    {
        return repo.save(WorkingHoursVM.toEntity(workingHoursVM));
    }

    public void deleteById(Integer id) {
        Optional<WorkingHours> workingHours = repo.findById(id);
        if (workingHours.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Could not find working hours with id " + id);
        }
    }

    public WorkingHours getById(Integer id) {
        Optional<WorkingHours> workingHoursOptional = repo.findById(id);
        return workingHoursOptional.orElseThrow(() -> new EntityNotFoundException("Could not find working hours with id %d".formatted(id)));
    }

    public List<WorkingHours> getAll() {
        Optional<List<WorkingHours>> workingHours = Optional.of(repo.findAll());
        return workingHours.orElseThrow(() -> new EntityNotFoundException("There are no working hours"));
    }
}
