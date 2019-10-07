package com.example.jnetworks.controller;

import com.example.jnetworks.entity.Car;
import com.example.jnetworks.repository.CarRepository;
import com.example.jnetworks.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/registeredCars")
@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public Car registeredCar(@RequestBody  Car car) {
        return carService.saveCar(car);
    }

    @GetMapping
    public List<Car> searchRegisteredCar(@RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "size", defaultValue = "10") int size,
                                         @RequestParam(name = "carNumber", required = false) String carNumber,
                                         @RequestParam(name = "timestamp", required = false) String timestamp) throws ParseException {
            return carService.findAll(page, size, carNumber, timestamp).getContent();
    }

    @GetMapping(value = "/count")
    public long countOfRegisteredCars() {
        return carService.getCount();
    }
}
