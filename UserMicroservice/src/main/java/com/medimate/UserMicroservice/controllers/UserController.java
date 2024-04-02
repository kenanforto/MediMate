package com.medimate.UserMicroservice.controllers;

import com.medimate.UserMicroservice.models.User;
import com.medimate.UserMicroservice.services.UserService;
import com.medimate.UserMicroservice.viewmodels.UserVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User AddUser (@Valid @RequestBody UserVM userVM) {

        return userService.createUser(userVM);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return (users != null) ? ResponseEntity.ok(users) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUser( @PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public User editUser(
            @PathVariable("id") Integer id,
            @Valid @RequestBody UserVM userVM
    ) {
        return userService.editUser(id, userVM);
    }

    @PostMapping("/{id}/role/{roleId}")
    public ResponseEntity<User> addRoleToUser(@PathVariable Integer id, @PathVariable Integer roleId) {
        User user = userService.addRoleToUser(id, roleId);
        return ResponseEntity.status(200).body(user);
    }
}