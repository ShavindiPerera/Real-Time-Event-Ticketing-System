package com.ticketingsystem.backend.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class vendorSaveRequestDTO {

    private int vendorId;
    private String vendorName;

    public vendorSaveRequestDTO() {
    }

    public vendorSaveRequestDTO(int vendorId, String vendorName) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
}
