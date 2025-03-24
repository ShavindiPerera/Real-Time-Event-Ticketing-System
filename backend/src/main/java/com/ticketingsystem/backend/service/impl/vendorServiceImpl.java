package com.ticketingsystem.backend.service.impl;

import com.ticketingsystem.backend.dto.request.customerSaveRequestDTO;
import com.ticketingsystem.backend.dto.request.vendorSaveRequestDTO;
import com.ticketingsystem.backend.entity.Customer;
import com.ticketingsystem.backend.entity.Vendor;
import com.ticketingsystem.backend.repo.vendorRepo;
import com.ticketingsystem.backend.service.vendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class vendorServiceImpl implements vendorService {

    @Autowired
   private vendorRepo vendorRepo;

    @Override
    public String saveVendor(vendorSaveRequestDTO vendorRequestDTO) {
        //log.info("adding a new vendor, {}", vendorRequestDTO.getVendorId());

        Vendor vendor = new Vendor(
                vendorRequestDTO.getVendorId(),
                vendorRequestDTO.getVendorName()
        );
        vendorRepo.save(vendor);

        return "saved";
    }

    @Override
    public String updateVendor(vendorSaveRequestDTO vendorRequestDTO) {
        if (vendorRepo.existsById(vendorRequestDTO.getVendorId())) {

            Vendor vendor = vendorRepo.getReferenceById(vendorRequestDTO.getVendorId());
            vendor.setVendorName(vendorRequestDTO.getVendorName());
           vendorRepo.save(vendor);

            return vendorRequestDTO.getVendorName() + " has been updated...!";

        } else {
            return "something went wrong...!";
        }
    }

    @Override
    public List<vendorSaveRequestDTO> getAllVendors() {
        List<Vendor> vendors = vendorRepo.findAll();
        List<vendorSaveRequestDTO> vendorRequestDTO = new ArrayList<>();


        for (Vendor vendor : vendors) {

            vendorRequestDTO.add(new vendorSaveRequestDTO(
                    vendor.getVendorId(),
                    vendor.getVendorName()

            ));

        }
        return vendorRequestDTO;


    }

    @Override
    public String deleteVendor(int vendorId) {
        if (vendorRepo.existsById(vendorId)) {
            vendorRepo.deleteById(vendorId);
            return vendorId + " vendor has been deleted..!";
        } else {
            return "Vendor is not found...!";
        }
    }
}
