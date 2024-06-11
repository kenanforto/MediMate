package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.TrackWorkingHoursRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.TrackWorkingHoursVM;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackWorkingHoursService {

    @Autowired
    TrackWorkingHoursRepository repo;
    

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

    public Page<TrackWorkingHours> getAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<TrackWorkingHours> trackWorkingHours = repo.findAll(pageable);
        if (trackWorkingHours.isEmpty()) {
            throw new EntityNotFoundException("There are no tracked working hours");
        }
        return trackWorkingHours;
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

    public TrackWorkingHours updateById(Integer id, TrackWorkingHoursVM trackWorkingHoursVM) {
        TrackWorkingHours existingTrackWH = getById(id);

        existingTrackWH.setBreakHours(trackWorkingHoursVM.getBreakHours() != null ? trackWorkingHoursVM.getBreakHours() : existingTrackWH.getBreakHours());
        existingTrackWH.setTotalHours(trackWorkingHoursVM.getTotalHours() != null ? trackWorkingHoursVM.getTotalHours() : existingTrackWH.getTotalHours());


        return repo.save(existingTrackWH);
    }
}
