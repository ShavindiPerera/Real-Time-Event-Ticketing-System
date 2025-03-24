package com.ticketingsystem.backend.service;

import com.ticketingsystem.backend.dto.request.vendorSaveRequestDTO;

import java.util.List;

public interface vendorService {

    String saveVendor(vendorSaveRequestDTO vendorRequestDTO);


    String updateVendor(vendorSaveRequestDTO vendorRequestDTO);

    List<vendorSaveRequestDTO> getAllVendors();

    String deleteVendor(int vendorId);
}
