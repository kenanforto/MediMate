package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import com.medimate.WorkingHoursMicroservice.services.WorkingHoursService;
import com.medimate.WorkingHoursMicroservice.viewmodels.WorkingHoursVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("working-hours")
public class WorkingHoursController {

    @Autowired
    WorkingHoursService workingHoursService;

    @PostMapping
    public WorkingHours addOne(@RequestBody @Valid WorkingHoursVM workingHoursVM) {
        return workingHoursService.addOne(workingHoursVM);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Integer id) {
        workingHoursService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<WorkingHours> getById(@PathVariable Integer id) {
        //return ResponseEntity.ok(WorkingHours.builder().id(id).build());
        //return ResponseEntity.notFound().build();

        WorkingHours workingHours = workingHoursService.getById(id);
        if (workingHours != null) {
            return ResponseEntity.ok(workingHours);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<WorkingHours>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<WorkingHours> workingHours = workingHoursService.getAll(page, size, sortBy);

        return (workingHours != null && !workingHours.isEmpty()) ? ResponseEntity.ok().body(workingHours) : ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<WorkingHours> updateAdmin(@PathVariable Integer id, @RequestBody WorkingHoursVM workingHoursVM) {
        WorkingHours updatedWorkingHours = workingHoursService.updateById(id, workingHoursVM);
        return ResponseEntity.ok(updatedWorkingHours);
    }
}
