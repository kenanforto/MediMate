package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.services.AdminService;
import com.medimate.WorkingHoursMicroservice.viewmodels.AdminVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admins")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping
    public Admin addOne(@RequestBody @Valid AdminVM adminVM) {
        return adminService.addOne(adminVM);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Admin> getById(@PathVariable Integer id) {
        Admin admin = adminService.getById(id);

        return (admin != null) ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<Admin>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        Page<Admin> admins = adminService.getAll(page, size, sortBy, firstName, lastName);

        return (admins != null && !admins.isEmpty()) ? ResponseEntity.ok().body(admins) : ResponseEntity.notFound().build();
    }


    @PutMapping("{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id, @RequestBody AdminVM adminVM) {
        Admin updatedAdmin = adminService.updateById(id, adminVM);
        return ResponseEntity.ok(updatedAdmin);
    }
}
