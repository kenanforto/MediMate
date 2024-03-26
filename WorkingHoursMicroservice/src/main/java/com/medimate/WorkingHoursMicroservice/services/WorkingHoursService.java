package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.WorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.WorkingHoursVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkingHoursService {

    @Autowired
    private WorkingHoursRepository repo;
    public void addOne(WorkingHoursVM workingHoursVM){
        repo.save(
                new WorkingHours(
                        workingHoursVM.getStartTime(),
                        workingHoursVM.getEndTime(),
                        workingHoursVM.getTitle(),
                        workingHoursVM.getDoctor(),
                        workingHoursVM.getTrackWorkingHours()
                )
        );
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public WorkingHours getById(Integer id) {
        Optional<WorkingHours> workingHoursOptional = repo.findById(id);
        return workingHoursOptional.orElse(null);
    }
}
