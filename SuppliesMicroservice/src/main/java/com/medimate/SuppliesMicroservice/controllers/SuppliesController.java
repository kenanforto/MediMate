package com.medimate.SuppliesMicroservice.controllers;

import com.medimate.SuppliesMicroservice.models.Admin;
import com.medimate.SuppliesMicroservice.models.Supplies;
import com.medimate.SuppliesMicroservice.services.AdminService;
import com.medimate.SuppliesMicroservice.services.SuppliesService;
import com.medimate.SuppliesMicroservice.viewmodels.AdminVM;
import com.medimate.SuppliesMicroservice.viewmodels.SuppliesVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("supplies")
public class SuppliesController {

    @Autowired
    SuppliesService suppliesService;

    @PostMapping("")
    public Supplies addOne(@RequestBody @Valid SuppliesVM suppliesVM){
        return suppliesService.addOne(suppliesVM);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        suppliesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Supplies> getById(@PathVariable Integer id){
        Supplies supplies = suppliesService.getById(id);

        if (supplies != null) {
            return ResponseEntity.ok(supplies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
