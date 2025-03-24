package com.ticketingsystem.backend.controller;


import com.ticketingsystem.backend.dto.request.configurationSaveRequestDTO;
import com.ticketingsystem.backend.dto.response.ConfigurationResponseDTO;
import com.ticketingsystem.backend.entity.Configuration;
import com.ticketingsystem.backend.service.configurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/configuration")
public class ConfigurationController {

    @Autowired
    private configurationService Service;

    @PostMapping(path = "/save-configuration")
    public String saveConfiguration(@RequestBody configurationSaveRequestDTO saveConfigurationDTO){

        String message = Service.saveConfiguration(saveConfigurationDTO);


        return message;
    }

    /*@PostMapping(path = "/save-configuration")
    public String saveConfiguration(@RequestBody configurationSaveRequestDTO saveConfigurationDTO) {
        // Call the service method to save the configuration and get the response DTO
        ConfigurationResponseDTO responseDTO = configurationService.saveConfiguration(saveConfigurationDTO);

        // Return the message as a String
        return responseDTO.getMessage();  // Extract message and return as a string
    }*/






}





