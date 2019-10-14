package com.example.jnetworks.service;

import com.example.jnetworks.dto.CarDto;
import com.example.jnetworks.entity.Car;
import com.example.jnetworks.entity.CarsCount;

import java.text.ParseException;
import java.util.List;

public interface CarService {

    List<CarDto> findAll(int page, int size, String carNumber, String timestamp) throws ParseException;

    CarsCount getCount();

    CarDto saveCar(Car car);

}
