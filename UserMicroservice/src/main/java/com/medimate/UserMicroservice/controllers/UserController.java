package com.medimate.UserMicroservice.controllers;

import com.medimate.UserMicroservice.models.Role;
import com.medimate.UserMicroservice.models.User;
import com.medimate.UserMicroservice.repositories.AdminRepository;
import com.medimate.UserMicroservice.repositories.DoctorRepository;
import com.medimate.UserMicroservice.repositories.PatientRepository;
import com.medimate.UserMicroservice.services.UserService;
import com.medimate.UserMicroservice.viewmodels.ObjectDao;
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
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AdminRepository adminRepository;

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

    @GetMapping(path = "/getUser/{email}")
    public ResponseEntity<ObjectDao> getUserId(@PathVariable String email)
    {
        User user = userService.getUserByEmail(email);
        ObjectDao object=new ObjectDao();

        if(user.getRole()==Role.PATIENT)
        {
            object.setRole(user.getRole());
            object.setFirstName(user.getFirstName());
            object.setId(patientRepository.findByUserId(user.getId()).getId());
        }
        else if (user.getRole()==Role.DOCTOR)
        {
            object.setRole(user.getRole());
            object.setFirstName(user.getFirstName());
            object.setId(doctorRepository.findByUserId(user.getId()).getId());
        }
        else
        {
            object.setRole(user.getRole());
            object.setFirstName(user.getFirstName());
            object.setId(adminRepository.findByUserId(user.getId()).getId());
        }
        return  ResponseEntity.ok(object);
    }
    @GetMapping(path = "/id/{email}")
    public ResponseEntity<Integer> getUserIdByEmail(@PathVariable String email)
    {
        return userService.getUserIdByEmail(email);
    }

    @PatchMapping(path = "/upgrade-role/{email}")
    public ResponseEntity<String> upgradeRole(@PathVariable String email)
    {
        return userService.upgradeRole(email);
    }
}