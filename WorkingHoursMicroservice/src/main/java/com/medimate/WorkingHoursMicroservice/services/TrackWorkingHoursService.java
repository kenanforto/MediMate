package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.TrackWorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.TrackWorkingHoursVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackWorkingHoursService {

    @Autowired
    TrackWorkingHoursRepository repo;

    public TrackWorkingHours addOne(TrackWorkingHoursVM trackWorkingHoursVM){
        return repo.save(
                new TrackWorkingHours(
                        trackWorkingHoursVM.getTotalHours(),
                        trackWorkingHoursVM.getBreakHours(),
                        trackWorkingHoursVM.getAdmin()
                )
        );
    }


    public void deleteById(Integer id){
        repo.deleteById(id);
    }
    public TrackWorkingHours getById(Integer id){
        Optional<TrackWorkingHours> trackWorkingHoursOptional = repo.findById(id);
        return trackWorkingHoursOptional.orElseThrow(() -> new EntityNotFoundException("Could not find track working hours with id %d".formatted(id)));
    }
}
