package com.medimate.SuppliesMicroservice.viewmodels;

public class SuppliesVM {

    private String medicationName;
    private Integer amount;

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
}
