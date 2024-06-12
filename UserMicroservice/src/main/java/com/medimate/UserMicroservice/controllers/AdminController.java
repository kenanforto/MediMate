package com.medimate.UserMicroservice.controllers;

import com.medimate.UserMicroservice.models.Admin;
import com.medimate.UserMicroservice.services.AdminService;
import com.medimate.UserMicroservice.viewmodels.AdminVM;
import jakarta.validation.Valid;
import jakarta.ws.rs.DefaultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam(defaultValue = "id") String sortBy
//            @RequestParam(required = false) @DefaultValue("") String firstName,
//            @RequestParam(required = false) @DefaultValue("") String lastName
    ) {
        Page<Admin> admins = adminService.getAll(page, size, sortBy);

        return (admins != null && !admins.isEmpty()) ? ResponseEntity.ok().body(admins) : ResponseEntity.notFound().build();
    }


//    @PutMapping("{id}")
//    public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id, @RequestBody AdminVM adminVM) {
//        Admin updatedAdmin = adminService.updateById(id, adminVM);
//        return ResponseEntity.ok(updatedAdmin);
//    }
}
