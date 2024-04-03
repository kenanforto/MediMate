package com.medimate.UserMicroservice.controllers;

import com.medimate.UserMicroservice.models.Role;
import com.medimate.UserMicroservice.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<Role> getAllRoles(@RequestParam(required = false) String name) {
        Role role = roleService.getRole(name);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById( @PathVariable("id") Integer id) {
        return new ResponseEntity<>(roleService.getRole(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Role> createRole(@Valid @RequestBody Role role) {
        return new ResponseEntity<>(roleService.addRole(role), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") Integer id, @Valid @RequestBody Role role) {
        return new ResponseEntity<>(roleService.updateRole(id, role), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/role")
    public ResponseEntity<HttpStatus> deleteAllRoles() {
        roleService.deleteRole(null);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}