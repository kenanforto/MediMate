package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.services.AdminService;
import com.medimate.WorkingHoursMicroservice.viewmodels.AdminVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("admin/add")
    public void addOne(@RequestBody AdminVM adminVM){
        adminService.addOne(adminVM);
    }

    @DeleteMapping("admin/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getById(@PathVariable Integer id){
        Admin admin = adminService.getById(id);

        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
