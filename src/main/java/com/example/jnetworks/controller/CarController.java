package com.example.jnetworks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @PostMapping(value = "/registeredCars")
    public String registeredCar() {
        return "Car was registered";
    }

    @GetMapping(value = "/registeredCars")
    public String searchRegisteredCar() {
        return "Its cars";
    }

    @GetMapping(value = "/registeredCars/count")
    public int countOfRegisteredCars() {
        return 10;
    }

}
