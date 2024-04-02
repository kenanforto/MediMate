package com.medimate.SuppliesMicroservice.viewmodels;

import com.medimate.SuppliesMicroservice.models.Supplies;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SuppliesVM {

    @NotBlank
    @NotNull
    @Pattern(regexp = "[A-Za-z]+")
    private String medicationName;

    @NotNull
    @Min(1)
    private Integer amount;

    @NotNull
    private Integer adminId;

    public SuppliesVM(String medicationName, Integer amount, Integer adminId) {
        this.medicationName = medicationName;
        this.amount = amount;
        this.adminId = adminId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public static Supplies toEntity(SuppliesVM suppliesVM) {
        return new Supplies(suppliesVM.medicationName, suppliesVM.amount, suppliesVM.adminId);
    }
}
