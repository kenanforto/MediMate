package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.AdminRepository;
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

    @Autowired
    AdminRepository adminRepo;

    public TrackWorkingHours addOne(TrackWorkingHoursVM trackWorkingHoursVM){
        return repo.save(
                new TrackWorkingHours(
                        trackWorkingHoursVM.getTotalHours(),
                        trackWorkingHoursVM.getBreakHours(),
                        adminRepo.findById(trackWorkingHoursVM.getAdminId()).orElse(null))
        );
    }

    public void deleteById(Integer id) {
        Optional<TrackWorkingHours> trackWorkingHoursOptional = repo.findById(id);
        if(trackWorkingHoursOptional.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Could not find tracked working hours with id " + id);
        }
    }

    public TrackWorkingHours getById(Integer id){
        Optional<TrackWorkingHours> trackWorkingHoursOptional = repo.findById(id);
        return trackWorkingHoursOptional.orElseThrow(() -> new EntityNotFoundException("Could not find track working hours with id %d".formatted(id)));
    }
}
