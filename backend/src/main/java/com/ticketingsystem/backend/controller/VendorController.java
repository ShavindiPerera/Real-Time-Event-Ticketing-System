package com.ticketingsystem.backend.controller;


import com.ticketingsystem.backend.dto.request.customerSaveRequestDTO;
import com.ticketingsystem.backend.dto.request.vendorSaveRequestDTO;
import com.ticketingsystem.backend.service.customerService;
import com.ticketingsystem.backend.service.vendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/vendor")
public class VendorController {

    @Autowired
    private vendorService Service;

    @PostMapping(path = "/save-vendor")
    public String saveVendor(@RequestBody vendorSaveRequestDTO vendorRequestDTO) {

        String message = Service.saveVendor(vendorRequestDTO);


        return message;
    }

    @PutMapping(path = "/update-vendor")
    public String updateCustomer(@RequestBody vendorSaveRequestDTO vendorRequestDTO) {
        String message = Service.updateVendor(vendorRequestDTO);

        return message;
    }

    @GetMapping(path = "/get-all-vendors")
    public List<vendorSaveRequestDTO> getAllVendors() {

        return Service.getAllVendors();
    }

    @DeleteMapping(path = "/delete-vendor/{id}")
    public String deleteVendor(@PathVariable(value = "id") int vendorId) {

        return Service.deleteVendor(vendorId);
    }
}
