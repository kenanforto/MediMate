package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.services.TrackWorkingHoursService;
import com.medimate.WorkingHoursMicroservice.viewmodels.TrackWorkingHoursVM;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("track-working-hours")
public class TrackWorkingHoursController {

    @Autowired
    TrackWorkingHoursService trackWorkingHoursService;

    @PostMapping
    public TrackWorkingHours addOne(@RequestBody @Valid TrackWorkingHoursVM trackWorkingHoursVM) {
        return trackWorkingHoursService.addOne(trackWorkingHoursVM);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        trackWorkingHoursService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<TrackWorkingHours> getById(@PathVariable Integer id) {
        TrackWorkingHours trackWorkingHours = trackWorkingHoursService.getById(id);
        if (trackWorkingHours != null) {
            return ResponseEntity.ok(trackWorkingHours);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<TrackWorkingHours>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<TrackWorkingHours> trackWorkingHours = trackWorkingHoursService.getAll(page, size, sortBy);

        return (trackWorkingHours != null && !trackWorkingHours.isEmpty()) ? ResponseEntity.ok().body(trackWorkingHours) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "admin/{adminId}")
    public ResponseEntity<List<TrackWorkingHours>> getAllByAdminId(
            @PathVariable Integer adminId
    ) {
        List<TrackWorkingHours> trackWorkingHours = trackWorkingHoursService.getByAdminId(adminId);
        return (trackWorkingHours != null) ? ResponseEntity.ok(trackWorkingHours) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{trackWorkingHoursId}/admin/{adminId}")
    @Transactional
    public ResponseEntity<Void> deleteMedicalRecordForPatient(
            @PathVariable Integer trackWorkingHoursId,
            @PathVariable Integer adminId
    ) {
        trackWorkingHoursService.deleteOneForAdmin(trackWorkingHoursId, adminId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "admin/{adminId}")
    @Transactional
    public ResponseEntity<Void> deleteAllMedicalRecordsForPatient(
            @PathVariable Integer adminId
    ) {
        trackWorkingHoursService.deleteAllForAdmin(adminId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<TrackWorkingHours> updateAdmin(@PathVariable Integer id, @RequestBody TrackWorkingHoursVM trackWorkingHoursVM) {
        TrackWorkingHours updatedTrackWH = trackWorkingHoursService.updateById(id, trackWorkingHoursVM);
        return ResponseEntity.ok(updatedTrackWH);
    }
}
