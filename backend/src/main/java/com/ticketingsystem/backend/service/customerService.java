package com.ticketingsystem.backend.service;

import com.ticketingsystem.backend.dto.request.customerSaveRequestDTO;

import java.util.List;

public interface customerService {


    

    List<customerSaveRequestDTO> getAllCustomers();

    String saveCustomer(customerSaveRequestDTO saveRequestDTO);

    String updateCustomer(customerSaveRequestDTO requestDTO);

    String deleteCustomer(int customerID);
}
