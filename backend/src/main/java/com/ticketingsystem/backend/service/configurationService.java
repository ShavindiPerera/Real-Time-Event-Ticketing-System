package com.ticketingsystem.backend.service;

import com.ticketingsystem.backend.dto.request.configurationSaveRequestDTO;

public interface configurationService {


    String saveConfiguration(configurationSaveRequestDTO saveConfigurationDTO);
}
