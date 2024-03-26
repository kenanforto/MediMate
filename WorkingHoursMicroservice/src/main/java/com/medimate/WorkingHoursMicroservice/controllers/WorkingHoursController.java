package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import com.medimate.WorkingHoursMicroservice.services.WorkingHoursService;
import com.medimate.WorkingHoursMicroservice.viewmodels.WorkingHoursVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkingHoursController {

    @Autowired
    WorkingHoursService workingHoursService;

    @PostMapping("/working-hours/add")
    public void addOne(@RequestBody WorkingHoursVM workingHoursVM){
        workingHoursService.addOne(workingHoursVM);
    }

    @DeleteMapping("/working-hours/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Integer id){
        workingHoursService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/working-hours/{id}")
    public ResponseEntity<WorkingHours> getById(@PathVariable Integer id){
        //return ResponseEntity.ok(WorkingHours.builder().id(id).build());
        //return ResponseEntity.notFound().build();

        WorkingHours workingHours = workingHoursService.getById(id);
        if (workingHours != null) {
            return ResponseEntity.ok(workingHours);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
