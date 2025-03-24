package com.ticketingsystem.backend.service;

import com.ticketingsystem.backend.dto.request.configurationSaveRequestDTO;

public interface ticketService {


    String startSimulation(configurationSaveRequestDTO saveConfigurationDTO);


    String stopSimulation(configurationSaveRequestDTO saveConfigurationDTO);
}
