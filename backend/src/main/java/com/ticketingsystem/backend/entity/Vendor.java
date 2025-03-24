package com.ticketingsystem.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendor")
public class Vendor {


    @Id
    @Column(name = "vendor_id" ,length = 10)
    private int vendorId;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    public Vendor() {
    }

    public Vendor(int vendorId, String vendorName) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }


}
