package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.services.AdminService;
import com.medimate.WorkingHoursMicroservice.viewmodels.AdminVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admins")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("")
    public Admin addOne(@RequestBody @Valid AdminVM adminVM){
       return adminService.addOne(adminVM);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Admin> getById(@PathVariable Integer id){
        Admin admin = adminService.getById(id);

        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
