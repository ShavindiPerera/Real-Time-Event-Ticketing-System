package com.ticketingsystem.backend.controller;


import com.ticketingsystem.backend.dto.request.customerSaveRequestDTO;
import com.ticketingsystem.backend.entity.Customer;
import com.ticketingsystem.backend.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private customerService service;

    @PostMapping(path = "/save-customer")
    public String saveCustomer(@RequestBody customerSaveRequestDTO saveRequestDTO){

        String message = service.saveCustomer(saveRequestDTO);


        return message;
    }

    @PutMapping(path = "/update-customer")
    public String updateCustomer(@RequestBody customerSaveRequestDTO RequestDTO){
        String message = service.updateCustomer(RequestDTO);

        return message;
    }

    @GetMapping(path = "/get-all-customers")
    public List<customerSaveRequestDTO> getAllCustomers() {

        return service.getAllCustomers();
    }


    @DeleteMapping(path = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerID) {

        return service.deleteCustomer(customerID);
    }




}
