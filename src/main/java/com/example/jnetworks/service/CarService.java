package com.example.jnetworks.service;

import com.example.jnetworks.entity.Car;
import org.springframework.data.domain.Page;

import java.sql.Timestamp;
import java.text.ParseException;

public interface CarService {

    Page<Car> findAll(int page, int size, String carNumber, String timestamp) throws ParseException;

    long getCount();

    Car saveCar(Car car);

}
