package com.example.jnetworks.controller;

import com.example.jnetworks.entity.Car;
import com.example.jnetworks.repository.CarRepository;
import com.example.jnetworks.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(value = "/registeredCars")
    public Car registeredCar(@RequestBody  Car car) {
        return carService.saveCar(car);
    }

    @GetMapping(value = "/registeredCars")
    public List<Car> searchRegisteredCar() {
        return carService.findAll();
    }

    @GetMapping(value = "/registeredCars/count")
    public long countOfRegisteredCars() {
        return carService.getCount();
    }
}
