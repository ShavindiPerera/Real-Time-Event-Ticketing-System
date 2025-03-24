package com.ticketingsystem.backend.service.impl;

import com.ticketingsystem.backend.dto.request.configurationSaveRequestDTO;
import com.ticketingsystem.backend.entity.Configuration;
import com.ticketingsystem.backend.entity.Vendor;
import com.ticketingsystem.backend.repo.configurationRepo;
import com.ticketingsystem.backend.repo.vendorRepo;
import com.ticketingsystem.backend.service.ticketService;
import com.ticketingsystem.backend.ticketmanagement.CustomerThread;
import com.ticketingsystem.backend.ticketmanagement.TicketPool;
import com.ticketingsystem.backend.ticketmanagement.VendorThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ticketServiceImpl implements ticketService {

    @Autowired
    private configurationRepo configurationRepo;

    @Autowired
    private vendorRepo VendorRepo;

    private boolean isRunning = false;


    @Override
    public String startSimulation(configurationSaveRequestDTO saveConfigurationDTO) {

        if (isRunning) {
            throw new IllegalStateException("Simulation is already running.");
        }

        // Map DTO to Entity correctly
        Configuration config = new Configuration();
        config.setId(saveConfigurationDTO.getId());
        config.setMaxTicketCapacity(saveConfigurationDTO.getMaxTicketCapacity());
        config.setTotalTickets(saveConfigurationDTO.getTotalTickets());
        config.setTicketReleaseRate(saveConfigurationDTO.getTicketReleaseRate());
        config.setCustomerRetrievalRate(saveConfigurationDTO.getCustomerRetrievalRate());

        // Optional: Save configuration to DB
        configurationRepo.save(config);

        isRunning = true;

        // Initialize ticket pool with max ticket capacity
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Start vendor threads
        VendorThread[] vendors = new VendorThread[100];
        for (int i = 1; i < vendors.length; i++) {
            vendors[i] = new VendorThread(ticketPool, config.getTotalTickets(), config.getTicketReleaseRate());
            Thread vendorThread = new Thread(vendors[i], "Vendor " + i);
            vendorThread.start();
        }
        log.info("vendor threads started");

        // Start customer threads
        CustomerThread[] customers = new CustomerThread[100];
        for (int j = 1; j < customers.length; j++) {
            customers[j] = new CustomerThread(ticketPool, config.getCustomerRetrievalRate(), 10);
            Thread customerThread = new Thread(customers[j], "Customer " + j);
            customerThread.start();
            log.info("customer threads started");
        }

        return "Simulation started...";

    }


    @Override
    public String stopSimulation(configurationSaveRequestDTO saveConfigurationDTO) {
        //log.warn("error in simulation stop");
        if (!isRunning) {
            throw new IllegalStateException("Simulation is not running.");
        }

        isRunning = false;

        System.out.println("Ticket handling simulation stopped.");

        //log.info("simulation stopped");

        return "Simulation stopped successfully.";
    }


}
