package com.example.jnetworks.service;

import com.example.jnetworks.entity.Car;
import com.example.jnetworks.entity.CarsCount;
import org.springframework.data.domain.Page;

import java.text.ParseException;

public interface CarService {

    Page<Car> findAll(int page, int size, String carNumber, String timestamp) throws ParseException;

    CarsCount getCount();

    Car saveCar(Car car);

}
