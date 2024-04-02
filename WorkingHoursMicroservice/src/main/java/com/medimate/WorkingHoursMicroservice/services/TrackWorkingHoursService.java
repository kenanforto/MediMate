package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.AdminRepository;
import com.medimate.WorkingHoursMicroservice.repositories.TrackWorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.TrackWorkingHoursVM;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackWorkingHoursService {

    @Autowired
    TrackWorkingHoursRepository repo;

    @Autowired
    AdminRepository adminRepo;

    public TrackWorkingHours addOne(TrackWorkingHoursVM trackWorkingHoursVM) {
        return repo.save(
                TrackWorkingHoursVM.toEntity(trackWorkingHoursVM)
        );
    }

    public void deleteById(Integer id) {
        Optional<TrackWorkingHours> trackWorkingHoursOptional = repo.findById(id);
        if (trackWorkingHoursOptional.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Could not find tracked working hours with id " + id);
        }
    }

    public TrackWorkingHours getById(Integer id) {
        Optional<TrackWorkingHours> trackWorkingHoursOptional = repo.findById(id);
        return trackWorkingHoursOptional.orElseThrow(() -> new EntityNotFoundException("Could not find track working hours with id %d".formatted(id)));
    }

    public List<TrackWorkingHours> getAll() {
        Optional<List<TrackWorkingHours>> trackWorkingHours = Optional.of(repo.findAll());
        return trackWorkingHours.orElseThrow(() -> new EntityNotFoundException("There are no tracked working hours"));
    }

    public List<TrackWorkingHours> getByAdminId(Integer adminId) {
        List<TrackWorkingHours> trackWorkingHours = repo.findByAdminId(adminId);
        if (trackWorkingHours.isEmpty())
            throw new EntityExistsException("Could not find tracked wroking hours with admin id " + adminId);
        return trackWorkingHours;
    }

    public void deleteOneForAdmin(Integer id, Integer adminId) {
        repo.deleteByAdminId(id, adminId);
    }

    public void deleteAllForAdmin(Integer adminId) {
        repo.deleteAllByAdminId(adminId);
    }
}
