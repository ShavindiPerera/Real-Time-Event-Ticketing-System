package com.ticketingsystem.backend.repo;

import com.ticketingsystem.backend.dto.request.configurationSaveRequestDTO;
import com.ticketingsystem.backend.entity.Configuration;
import com.ticketingsystem.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface configurationRepo extends JpaRepository <Configuration, Integer> {
    Configuration findTopByOrderByIdDesc();

}
