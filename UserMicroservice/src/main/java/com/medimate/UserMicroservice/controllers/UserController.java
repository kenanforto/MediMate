package com.medimate.UserMicroservice.controllers;

import com.medimate.UserMicroservice.models.Role;
import com.medimate.UserMicroservice.models.User;
import com.medimate.UserMicroservice.services.UserService;
import com.medimate.UserMicroservice.viewmodels.UserVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User AddUser(@Valid @RequestBody UserVM userVM) {

        return userService.createUser(userVM);
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) String userName
    ) {
        Page<User> users = userService.getAllUsers(page, size, sortBy, userName);

        return (users != null && !users.isEmpty()) ? ResponseEntity.ok().body(users) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
    @GetMapping(path = "{email}")
    public ResponseEntity<User> getUser(@PathVariable("email") String email) {
        User user = userService.getUserByEmail(email);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "{id}")
    public User editUser(
            @PathVariable("id") Integer id,
            @Valid @RequestBody UserVM userVM
    ) {
        return userService.editUser(id, userVM);
    }

    @PostMapping("{id}/role/{roleId}")
    public ResponseEntity<User> addRoleToUser(@PathVariable Integer id, @PathVariable Role roleId) {
        User user = userService.addRoleToUser(id, roleId);
        return ResponseEntity.status(200).body(user);
    }
}