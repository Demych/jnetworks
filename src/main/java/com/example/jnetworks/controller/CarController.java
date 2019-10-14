package com.example.jnetworks.controller;

import com.example.jnetworks.dto.CarDto;
import com.example.jnetworks.entity.Car;
import com.example.jnetworks.entity.CarsCount;
import com.example.jnetworks.service.CarService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RequestMapping("/registeredCars")
@RestController
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    Mapper mapper;

    @PostMapping
    public ResponseEntity<CarDto> registeredCar(@RequestBody @Valid CarDto carDto) {
        return ResponseEntity.ok(carService.saveCar(mapper.map(carDto, Car.class)));
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> searchRegisteredCar(@RequestParam(name = "page", defaultValue = "0") int page,
                                                         @RequestParam(name = "size", defaultValue = "10") int size,
                                                         @RequestParam(name = "carNumber", required = false) String carNumber,
                                                         @RequestParam(name = "date",  required = false)  String timestamp) throws ParseException {
            return ResponseEntity.ok(carService.findAll(page, size, carNumber, timestamp));
    }

    @GetMapping(value = "/count")
    public CarsCount countOfRegisteredCars()
    {
        return carService.getCount();
    }
}
