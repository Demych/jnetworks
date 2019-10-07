package com.example.jnetworks.controller;

import com.example.jnetworks.entity.Car;
import com.example.jnetworks.entity.CarsCount;
import com.example.jnetworks.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/registeredCars")
@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public ResponseEntity<Car> registeredCar(@RequestBody  Car car) {
        return ResponseEntity.ok(carService.saveCar(car));
    }

    @GetMapping
    public ResponseEntity<List<Car>> searchRegisteredCar(@RequestParam(name = "page", defaultValue = "0") int page,
                                                         @RequestParam(name = "size", defaultValue = "10") int size,
                                                         @RequestParam(name = "carNumber", required = false) String carNumber,
                                                         @RequestParam(name = "timestamp", required = false) String timestamp) throws ParseException {
            return ResponseEntity.ok(carService.findAll(page, size, carNumber, timestamp).getContent());
    }

    @GetMapping(value = "/count")
    public CarsCount countOfRegisteredCars()
    {
        return carService.getCount();
    }
}
