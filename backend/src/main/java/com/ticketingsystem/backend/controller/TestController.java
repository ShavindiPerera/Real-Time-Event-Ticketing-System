package com.ticketingsystem.backend.controller;


import com.ticketingsystem.backend.entity.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping(path ="/get-test")
    public String getMyText(){
      return "Hello word";
    }

    @GetMapping(path = "/get-name")
    public String getName(){
        return "SP";
    }
}



