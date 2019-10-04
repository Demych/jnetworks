package com.example.jnetworks.service;

import com.example.jnetworks.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    long getCount();

    Car saveCar(Car car);

}
