package com.ticketingsystem.backend.dto.request;

import com.ticketingsystem.backend.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

public class customerSaveRequestDTO {


    private int customerId;
    private String customerName;

    public customerSaveRequestDTO() {
    }

    public customerSaveRequestDTO(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
