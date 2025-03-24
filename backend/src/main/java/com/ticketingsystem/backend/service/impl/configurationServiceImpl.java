package com.ticketingsystem.backend.service.impl;


import com.ticketingsystem.backend.dto.request.configurationSaveRequestDTO;
import com.ticketingsystem.backend.entity.Configuration;
import com.ticketingsystem.backend.repo.configurationRepo;
import com.ticketingsystem.backend.service.configurationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class configurationServiceImpl implements configurationService {

    @Autowired
    private configurationRepo configurationRepo;

    @Override
   /* public Configuration saveConfiguration(configurationSaveRequestDTO saveConfigurationDTO) {
        Configuration configuration = new Configuration(
                saveConfigurationDTO.getId(),
                saveConfigurationDTO.getTotalTickets(),
                saveConfigurationDTO.getTicketReleaseRate(),
                saveConfigurationDTO.getCustomerRetrievalRate(),
                saveConfigurationDTO.getMaxTicketCapacity()
        );
        return configurationRepo.save(configuration);


    }*/
    /*public ConfigurationResponseDTO saveConfiguration(configurationSaveRequestDTO saveConfigurationDTO) {
        Configuration config = new Configuration();
        config.setMaxTicketCapacity(saveConfigurationDTO.getMaxTicketCapacity());
        config.setTotalTickets(saveConfigurationDTO.getTotalTickets());
        config.setTicketReleaseRate(saveConfigurationDTO.getTicketReleaseRate());
        config.setCustomerRetrievalRate(saveConfigurationDTO.getCustomerRetrievalRate());

        return configurationRepo.save(config);
    }*/

    /*public ConfigurationResponseDTO saveConfiguration(configurationSaveRequestDTO saveConfigurationDTO) {
        Configuration config = new Configuration();
        config.setMaxTicketCapacity(saveConfigurationDTO.getMaxTicketCapacity());
        config.setTotalTickets(saveConfigurationDTO.getTotalTickets());
        config.setTicketReleaseRate(saveConfigurationDTO.getTicketReleaseRate());
        config.setCustomerRetrievalRate(saveConfigurationDTO.getCustomerRetrievalRate());

        Configuration savedConfig = configurationRepo.save(config);

        return new ConfigurationResponseDTO(savedConfig.getId(), "Configuration saved successfully");
    }
     */

    /*public ConfigurationResponseDTO saveConfiguration(configurationSaveRequestDTO saveConfigurationDTO) {
        // Optionally, validate the DTO before saving
        if (saveConfigurationDTO.getMaxTicketCapacity() <= 0 || saveConfigurationDTO.getTotalTickets() <= 0) {
            throw new IllegalArgumentException("Max ticket capacity and total tickets must be greater than zero.");
        }

        // Create the configuration entity from the DTO
        Configuration config = new Configuration();
        config.setMaxTicketCapacity(saveConfigurationDTO.getMaxTicketCapacity());
        config.setTotalTickets(saveConfigurationDTO.getTotalTickets());
        config.setTicketReleaseRate(saveConfigurationDTO.getTicketReleaseRate());
        config.setCustomerRetrievalRate(saveConfigurationDTO.getCustomerRetrievalRate());

        // Save the configuration to the database
        Configuration savedConfig = configurationRepo.save(config);

        // Return a response DTO with the saved configuration ID (Long) and a success message
        return new ConfigurationResponseDTO(savedConfig.getId(), "Configuration saved successfully");
    }*/

    public String saveConfiguration(configurationSaveRequestDTO saveConfigurationDTO) {
        // Optionally, validate the DTO before saving
        if (saveConfigurationDTO.getMaxTicketCapacity() <= 0 || saveConfigurationDTO.getTotalTickets() <= 0) {
            throw new IllegalArgumentException("Max ticket capacity and total tickets must be greater than zero.");
        }

        // Create the configuration entity from the DTO
        Configuration config = new Configuration();
        config.setMaxTicketCapacity(saveConfigurationDTO.getMaxTicketCapacity());
        config.setTotalTickets(saveConfigurationDTO.getTotalTickets());
        config.setTicketReleaseRate(saveConfigurationDTO.getTicketReleaseRate());
        config.setCustomerRetrievalRate(saveConfigurationDTO.getCustomerRetrievalRate());

        // Save the configuration to the database
        Configuration savedConfig = configurationRepo.save(config);

        // Return a response DTO with the saved configuration ID (Long) and a success message
        //return new ConfigurationResponseDTO(savedConfig.getId(), "Configuration saved successfully");
        return "saved";
    }

}
