package com.medimate.SuppliesMicroservice.controllers;

import com.medimate.SuppliesMicroservice.models.Admin;
import com.medimate.SuppliesMicroservice.models.Supplies;
import com.medimate.SuppliesMicroservice.services.SuppliesService;
import com.medimate.SuppliesMicroservice.viewmodels.SuppliesVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("supplies")
public class SuppliesController {

    @Autowired
    SuppliesService suppliesService;

    @PostMapping
    public Supplies addOne(@RequestBody @Valid SuppliesVM suppliesVM) {
        return suppliesService.addOne(suppliesVM);
    }

    @GetMapping
    public ResponseEntity<Page<Supplies>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<Supplies> supplies = suppliesService.getAll(page, size, sortBy);

        return (supplies != null && !supplies.isEmpty()) ? ResponseEntity.ok().body(supplies) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        suppliesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Supplies> getById(@PathVariable Integer id) {
        Supplies supplies = suppliesService.getById(id);

        if (supplies != null) {
            return ResponseEntity.ok(supplies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Supplies> updateById(@PathVariable Integer id, @RequestBody SuppliesVM suppliesVM) {
        Supplies updatedSupplies = suppliesService.updateById(id, suppliesVM);
        return ResponseEntity.ok(updatedSupplies);
    }

}
