package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.services.TrackWorkingHoursService;
import com.medimate.WorkingHoursMicroservice.viewmodels.TrackWorkingHoursVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackWorkingHoursController {

    @Autowired
    TrackWorkingHoursService trackWorkingHoursService;

    @PostMapping("/track-working-hours/add")
    public void addOne(@RequestBody TrackWorkingHoursVM trackWorkingHoursVM){
        trackWorkingHoursService.addOne(trackWorkingHoursVM);
    }

    @DeleteMapping("/track-working-hours/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        trackWorkingHoursService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/track-working-hours/{id}")
    public ResponseEntity<TrackWorkingHours> getById(@PathVariable Integer id){
        TrackWorkingHours trackWorkingHours = trackWorkingHoursService.getById(id);
        if (trackWorkingHours != null) {
            return ResponseEntity.ok(trackWorkingHours);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}