package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.TrackWorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.TrackWorkingHoursVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackWorkingHoursService {

    @Autowired
    TrackWorkingHoursRepository repo;

    public void addOne(TrackWorkingHoursVM trackWorkingHoursVM){
        repo.save(
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
        return trackWorkingHoursOptional.orElse(null);
    }
}
