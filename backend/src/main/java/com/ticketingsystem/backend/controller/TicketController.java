package com.ticketingsystem.backend.controller;

import com.ticketingsystem.backend.dto.request.configurationSaveRequestDTO;
import com.ticketingsystem.backend.dto.request.customerSaveRequestDTO;
import com.ticketingsystem.backend.entity.Configuration;
import com.ticketingsystem.backend.repo.configurationRepo;
import com.ticketingsystem.backend.service.ticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/simulation")
public class TicketController {


    @Autowired
    private ticketService ticketService;

    @Autowired
    private configurationRepo configurationRepo;


    /*@PostMapping("/start")
    public String startSimulation(@RequestBody configurationSaveRequestDTO saveConfigurationDTO) {
        String message = ticketService.startSimulation(saveConfigurationDTO);


        return message;
    }*/


    @PostMapping("/start")
    public String startSimulation() {
        List<Configuration> configs = configurationRepo.findAll();

        if (configs.isEmpty()) {
            throw new RuntimeException("No configuration found in the database.");
        }

        Configuration lastConfig = configs.get(configs.size() - 1); // get the last item
        return ticketService.startSimulation(mapToDto(lastConfig));
    }




    private configurationSaveRequestDTO mapToDto(Configuration config) {
        configurationSaveRequestDTO dto = new configurationSaveRequestDTO();
        dto.setId(config.getId());
        dto.setMaxTicketCapacity(config.getMaxTicketCapacity());
        dto.setTotalTickets(config.getTotalTickets());
        dto.setTicketReleaseRate(config.getTicketReleaseRate());
        dto.setCustomerRetrievalRate(config.getCustomerRetrievalRate());
        return dto;
    }


    @PostMapping("/stop")
    public String stopSimulation(@RequestBody configurationSaveRequestDTO saveConfigurationDTO) {
        String message = ticketService.stopSimulation(saveConfigurationDTO);


        return message;
    }

}

