package com.ticketingsystem.backend.service.impl;

import com.ticketingsystem.backend.dto.request.customerSaveRequestDTO;
import com.ticketingsystem.backend.entity.Customer;
import com.ticketingsystem.backend.repo.customerRepo;
import com.ticketingsystem.backend.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class customerServiceImpl implements customerService {

    @Autowired
    private customerRepo customerRepo;

    @Override
    public List<customerSaveRequestDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        List<customerSaveRequestDTO> responseDTOS = new ArrayList<>();


        for (Customer customer : customers) {

            responseDTOS.add(new customerSaveRequestDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName()


            ));

        }
        return responseDTOS;

    }


    @Override
    public String saveCustomer(customerSaveRequestDTO saveRequestDTO) {

        Customer customer = new Customer(
                saveRequestDTO.getCustomerId(),
                saveRequestDTO.getCustomerName()
        );
        customerRepo.save(customer);


        return "saved";
    }

    @Override
    public String updateCustomer(customerSaveRequestDTO requestDTO) {

        if (customerRepo.existsById(requestDTO.getCustomerId())) {

            Customer customer = customerRepo.getReferenceById(requestDTO.getCustomerId());
            customer.setCustomerName(requestDTO.getCustomerName());
            customerRepo.save(customer);

            return requestDTO.getCustomerName() + " has been updated...!";

        } else {
            return "something went wrong...!";
        }

    }

    @Override
    public String deleteCustomer(int customerID) {
        if (customerRepo.existsById(customerID)) {
            customerRepo.deleteById(customerID);
            return customerID + " customer has been deleted..!";
        } else {
            return "Customer is not found...!";
        }

    }
}
